package com.wms.warehouseMS.service;

import com.wms.warehouseMS.dto.OrderItemRequest;
import com.wms.warehouseMS.dto.OrderRequest;
import com.wms.warehouseMS.entity.InventoryItem;
import com.wms.warehouseMS.entity.Order;
import com.wms.warehouseMS.entity.OrderItem;
import com.wms.warehouseMS.entity.Product;
import com.wms.warehouseMS.exception.InsufficientStockException;
import com.wms.warehouseMS.repository.InventoryRepository;
import com.wms.warehouseMS.repository.OrderRepository;
import com.wms.warehouseMS.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    private static final String STATUS_PACKED = "Packed";

    @Transactional
    public void packOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new RuntimeException("Order has no items");
        }

        for (OrderItem item : order.getItems()) {
            if (item.getProduct() == null || item.getProduct().getId() == null) {
                throw new RuntimeException("Product ID is missing in order item");
            }

            InventoryItem inventory = inventoryRepository
                    .findByProductId(item.getProduct().getId());

            if (inventory == null) {
                throw new RuntimeException("Inventory not found");
            }

            if (inventory.getQuantity() < item.getQuantity()) {
                throw new InsufficientStockException(
                        "Not enough stock for product: " + item.getProduct().getName()
                );
            }

            System.out.println("Reducing stock for product: " + item.getProduct().getName());

            inventory.setQuantity(inventory.getQuantity() - item.getQuantity());
        }

        order.setStatus(STATUS_PACKED);
    }


    public Order createOrder(OrderRequest request) {

        Order order = new Order();
        order.setStatus(request.getStatus());

        List<OrderItem> orderItems = new ArrayList<>();


        for (OrderItemRequest itemReq : request.getItems()) {
            System.out.println("Incoming Product ID: " + itemReq.getProductId());

            Product product = productRepository.findById(itemReq.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(itemReq.getQuantity());

            orderItems.add(item);
        }


        order.setItems(orderItems);

        return orderRepository.save(order);
    }
}
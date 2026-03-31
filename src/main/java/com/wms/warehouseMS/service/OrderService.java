package com.wms.warehouseMS.service;

import com.wms.warehouseMS.entity.InventoryItem;
import com.wms.warehouseMS.entity.Order;
import com.wms.warehouseMS.entity.OrderItem;
import com.wms.warehouseMS.exception.InsufficientStockException;
import com.wms.warehouseMS.repository.InventoryRepository;
import com.wms.warehouseMS.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional
    public void packOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        for (OrderItem item : order.getItems()) {
            InventoryItem inventory = inventoryRepository
                    .findAll()
                    .stream()
                    .filter(i -> i.getProduct().getId().equals(item.getProduct().getId()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Inventory not found"));

            if (inventory.getQuantity() < item.getQuantity()) {
                throw new InsufficientStockException("Not enough stock for product: "
                        + item.getProduct().getName());
            }
            //Reduce Stock
            inventory.setQuantity(inventory.getQuantity() - item.getQuantity());
            inventoryRepository.save(inventory);
        }

        order.setStatus("Packed");
        orderRepository.save(order);
    }
}




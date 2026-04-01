package com.wms.warehouseMS.controller;

import com.wms.warehouseMS.dto.OrderRequest;
import com.wms.warehouseMS.repository.OrderRepository;
import com.wms.warehouseMS.service.OrderService;
import com.wms.warehouseMS.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }



    @PostMapping("/{id}/pack")
    public String packOrder(@PathVariable Long id) {
        orderService.packOrder(id);
        return "Order packed successfully";
    }
}

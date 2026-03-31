package com.wms.warehouseMS.controller;

import com.wms.warehouseMS.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/{id}/pack")
    public String packOrder(@PathVariable Long id) {
        orderService.packOrder(id);
        return "Order packed successfully";
    }
}

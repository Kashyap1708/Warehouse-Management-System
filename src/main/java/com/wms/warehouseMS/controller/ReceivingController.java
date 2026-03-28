package com.wms.warehouseMS.controller;

import com.wms.warehouseMS.dto.ReceivingRequest;
import com.wms.warehouseMS.service.ReceivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receiving")
public class ReceivingController {
    @Autowired
    private ReceivingService receivingService;
    @PostMapping
    public String receiveStock(@RequestBody ReceivingRequest request){
        return  receivingService.receiveStock(request);
    }
}

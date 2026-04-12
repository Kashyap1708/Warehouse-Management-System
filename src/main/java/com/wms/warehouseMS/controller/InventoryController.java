package com.wms.warehouseMS.controller;

import com.wms.warehouseMS.entity.InventoryItem;
import com.wms.warehouseMS.entity.Product;
import com.wms.warehouseMS.entity.StorageBin;
import com.wms.warehouseMS.repository.ProductRepository;
import com.wms.warehouseMS.repository.StorageBinRepository;
import com.wms.warehouseMS.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;
    private final ProductRepository productRepo;
    private final StorageBinRepository storageBinRepo;

    public InventoryController(InventoryService service, ProductRepository productRepo, StorageBinRepository storageBinRepo) {
        this.service = service;
        this.productRepo = productRepo;
        this.storageBinRepo = storageBinRepo;
    }

    @GetMapping
    public List<InventoryItem> getAll() {
        return service.getAll();
    }
    @PostMapping
    public InventoryItem add(@RequestBody InventoryItem inventory) {

        Product product = productRepo.findById(inventory.getProduct().getId())
                .orElseThrow();

        StorageBin bin = storageBinRepo.findById(inventory.getStorageBin().getId())
                .orElseThrow();

        inventory.setProduct(product);
        inventory.setStorageBin(bin);

        return service.save(inventory);
    }
    }



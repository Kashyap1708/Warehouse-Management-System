package com.wms.warehouseMS.service;
import com.wms.warehouseMS.entity.InventoryItem;
import com.wms.warehouseMS.entity.Product;
import com.wms.warehouseMS.entity.StorageBin;
import com.wms.warehouseMS.repository.InventoryRepository;
import com.wms.warehouseMS.repository.ProductRepository;
import com.wms.warehouseMS.repository.StorageBinRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository repo;
    private final ProductRepository productRepo;
    private final StorageBinRepository storageRepo;

    public InventoryService(InventoryRepository repo,
                            ProductRepository productRepo,
                            StorageBinRepository storageRepo) {
        this.repo = repo;
        this.productRepo = productRepo;
        this.storageRepo = storageRepo;
    }
public List<InventoryItem>getAll(){
        return repo.findAll();
}
    public InventoryItem save(InventoryItem inventory) {

        // 🔥 fetch actual objects from DB
        Product product = productRepo.findById(inventory.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        StorageBin bin = storageRepo.findById(inventory.getStorageBin().getId())
                .orElseThrow(() -> new RuntimeException("StorageBin not found"));

        // 🔥 set properly
        inventory.setProduct(product);
        inventory.setStorageBin(bin);

        return repo.save(inventory);
    }
}

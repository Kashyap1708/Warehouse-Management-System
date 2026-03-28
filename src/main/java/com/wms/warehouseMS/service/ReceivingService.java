package com.wms.warehouseMS.service;

import com.wms.warehouseMS.dto.ReceivingRequest;
import com.wms.warehouseMS.entity.InventoryItem;
import com.wms.warehouseMS.entity.Product;
import com.wms.warehouseMS.entity.StorageBin;
import com.wms.warehouseMS.repository.InventoryRepository;
import com.wms.warehouseMS.repository.ProductRepository;
import com.wms.warehouseMS.repository.StorageBinRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceivingService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StorageBinRepository binRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional

    //Fetch Product
    public String receiveStock(ReceivingRequest request){
        Product product=productRepository.findById(request.getProductId())
                .orElseThrow(()->new RuntimeException("Product not found"));
        String zone;

        if(product.getCategory().equalsIgnoreCase("Electronics")) {
            zone = "E";
        } else if(product.getCategory().equalsIgnoreCase("Food")) {
            zone = "F";
        } else {
            zone = "G"; // general
        }

        // Find suitable bin (Putaway Logic)
        StorageBin bin = binRepository.findFirstByZone(zone);
        if(bin == null || (bin.getCapacity() - bin.getUsedCapacity()) < request.getQuantity()) {
            throw new RuntimeException("No suitable bin available");
        }

        //create Inventory Record
        InventoryItem item=new InventoryItem();
        item.setProduct(product);
        item.setStorageBin(bin);
        item.setQuantity(request.getQuantity());

        inventoryRepository.save(item);

        //update bin usage
        bin.setUsedCapacity(bin.getUsedCapacity() + request.getQuantity());
        binRepository.save(bin);

        return "Stock received and stored successfully";
    }
}

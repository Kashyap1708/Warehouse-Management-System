package com.wms.warehouseMS.repository;

import com.wms.warehouseMS.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
}

package com.wms.warehouseMS.repository;

import com.wms.warehouseMS.entity.StorageBin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageBinRepository extends JpaRepository<StorageBin, Long> {
    StorageBin findFirstByZone(String zone);

}

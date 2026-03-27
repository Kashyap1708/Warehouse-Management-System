package com.wms.warehouseMS.repository;

import com.wms.warehouseMS.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

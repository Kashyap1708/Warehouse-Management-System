package com.wms.warehouseMS.repository;

import com.wms.warehouseMS.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    }


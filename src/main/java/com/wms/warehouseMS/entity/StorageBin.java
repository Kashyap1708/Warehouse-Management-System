package com.wms.warehouseMS.entity;

import jakarta.persistence.*;

@Entity
public class StorageBin {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String zone;
    private String aisle;
    private int capacity;

    @ManyToOne
    @JoinColumn(name="warehouse_id")
    private Warehouse warehouse;
}

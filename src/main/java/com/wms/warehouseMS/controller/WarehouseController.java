package com.wms.warehouseMS.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    //  GET all warehouses
        @GetMapping
        public List<Map<String, Object>> getAllWarehouses() {
            List<Map<String, Object>> list = new ArrayList<>();

            Map<String, Object> w1 = new HashMap<>();
            w1.put("id", 1);
            w1.put("name", "Main Warehouse");
            w1.put("location", "Delhi");

            Map<String, Object> w2 = new HashMap<>();
            w2.put("id", 2);
            w2.put("name", "Secondary Warehouse");
            w2.put("location", "Mumbai");

            list.add(w1);
            list.add(w2);

            return list;
        }

        //  ADD warehouse
        @PostMapping
        public Map<String, Object> addWarehouse(@RequestBody Map<String, Object> data) {
            return data;
        }
    }


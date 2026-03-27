package com.wms.warehouseMS.controller;

import com.wms.warehouseMS.entity.Product;
import com.wms.warehouseMS.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);
    }
    @GetMapping
    public List<Product> getAllProducts()
    {
        return repository.findAll();
    }

}

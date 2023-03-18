package com.codingestion.setuplocaldbwithjasypt.controller;

import com.codingestion.setuplocaldbwithjasypt.model.Product;
import com.codingestion.setuplocaldbwithjasypt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<UUID> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }
}

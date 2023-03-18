package com.codingestion.setuplocaldbwithjasypt.service;

import com.codingestion.setuplocaldbwithjasypt.repository.ProductRepository;
import com.codingestion.setuplocaldbwithjasypt.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productDAO;

    @Autowired
    public ProductService(ProductRepository productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> findAll(){
        return (List<Product>) productDAO.findAll();
    }

    public UUID save(Product product){
        return productDAO.save(product).getId();
    }
}

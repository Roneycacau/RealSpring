package com.example.project.service;

import java.util.List;
import java.util.Optional;

import com.example.project.domain.Product;
import com.example.project.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id) {
        Optional<Product> status = productRepository.findById(id);
        return status;
    }
}
package com.example.project.service;

import java.util.List;
import java.util.Optional;
import java.io.File;
import java.io.IOException;

import com.example.project.domain.Product;
import com.example.project.domain.exception.DataNotFoundException;
import com.example.project.repository.ProductRepository;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        Optional<Product> status = productRepository.findById(id);
        return status.orElseThrow(() -> new DataNotFoundException("Evento não encontrado"));

    }

    public String upload(MultipartFile file, Integer id) {
        String dirName = File.separator + "temp" + File.separator + id;
        File dir = new File(dirName);

        if (!dir.exists())
            dir.mkdir();

        String filename = file.getOriginalFilename();
        File destFile = new File(dir + File.separator + filename);
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Product product = this.findById(id);
        product.setProductImage(dirName + File.separator + filename);
        productRepository.save(product);
        return destFile.getAbsolutePath();
    }

    public void saveBatch(Product entity) {
        productRepository.save(entity);
    }

    // public Product updateProduct(ProductRequestCreate product, Integer id) {
    // Product currentProduct = this.findById(id);

    // return null;
    // }
}
package com.example.project.service;

import java.util.List;
import java.util.Optional;

import com.example.project.domain.Supplier;
import com.example.project.repository.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> list() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> findById(Integer id) {
        Optional<Supplier> status = supplierRepository.findById(id);
        return status;
    }
}
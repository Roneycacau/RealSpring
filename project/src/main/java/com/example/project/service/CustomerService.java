package com.example.project.service;

import java.util.List;
import java.util.Optional;

import com.example.project.domain.Customer;
import com.example.project.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> list() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Integer id) {
        Optional<Customer> status = customerRepository.findById(id);
        return status;
    }
}
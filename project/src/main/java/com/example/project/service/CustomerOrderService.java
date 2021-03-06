package com.example.project.service;

import java.util.List;
import java.util.Optional;

import com.example.project.domain.CustomerOrder;
import com.example.project.repository.CustomerOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    public List<CustomerOrder> list() {
        return customerOrderRepository.findAll();
    }

    public Optional<CustomerOrder> findById(Integer id) {
        Optional<CustomerOrder> status = customerOrderRepository.findById(id);
        return status;
    }
}
package com.example.project.controller;

import java.util.List;
import java.util.Optional;

import com.example.project.domain.CustomerOrder;
import com.example.project.service.CustomerOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerOrder")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<CustomerOrder>> list() {
        return ResponseEntity.ok(customerOrderService.list());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<CustomerOrder>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(customerOrderService.findById(id));
    }

}
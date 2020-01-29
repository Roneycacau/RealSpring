package com.example.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer customerId;

    @Column(nullable = false, length = 40, columnDefinition = "nvarchar")
    private String firstName;

    @Column(nullable = false, length = 40, columnDefinition = "nvarchar")
    private String lastName;

    @Column(nullable = false, length = 40, columnDefinition = "nvarchar")
    private String city;

    @Column(nullable = false, length = 40, columnDefinition = "nvarchar")
    private String country;

    @Column(nullable = false, length = 40, columnDefinition = "nvarchar")
    private String phone;
}
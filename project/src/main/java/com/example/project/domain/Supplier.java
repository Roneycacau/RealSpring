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
@Table(name = "Supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer supplierId;

    @Column(name = "CompanyName", length = 40, nullable = false, columnDefinition = "nvarchar")
    private String companyName;

    @Column(name = "ContactName", length = 50, columnDefinition = "nvarchar")
    private String contactName;

    @Column(name = "ContactTitle", length = 40, columnDefinition = "nvarchar")
    private String contactTitle;

    @Column(name = "City", length = 40, columnDefinition = "nvarchar")
    private String city;

    @Column(name = "Country", length = 40, columnDefinition = "nvarchar")
    private String country;

    @Column(name = "Phone", length = 30, columnDefinition = "nvarchar")
    private String phone;

    @Column(name = "Fax", length = 30, columnDefinition = "nvarchar")
    private String fax;
}
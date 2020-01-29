package com.example.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer ProductId;

    @Column(name = "ProductName", length = 50, nullable = false, columnDefinition = "nvarchar")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "SupplierId", nullable = false)
    private Supplier supplierId;

    @Column(name = "UnitPrice", columnDefinition = "decimal(12,2) default 0")
    private Double unitPrice;

    @Column(name = "Package", length = 30, columnDefinition = "nvarchar")
    private String packageName;

    @Column(name = "IsDiscontinued", columnDefinition = "bit not null default 0")
    private Boolean discontinued;

    @Column(name = "ProductImage", columnDefinition = "nvarchar(1000)")
    private String productImage;

}
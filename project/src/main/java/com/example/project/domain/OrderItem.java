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
@Table(name = "OrderItem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer orderItemId;

    @ManyToOne
    @JoinColumn(name = "OrderId", nullable = false)
    private CustomerOrder orderId;

    @ManyToOne
    @JoinColumn(name = "ProductId", nullable = false)
    private Product productId;

    @Column(name = "UnitPrice", columnDefinition = "decimal(12,2) default 0", nullable = false)
    private Double unitPrice;

    @Column(name = "Quantity", columnDefinition = "int default 1", nullable = false)
    private Integer quantity;
}
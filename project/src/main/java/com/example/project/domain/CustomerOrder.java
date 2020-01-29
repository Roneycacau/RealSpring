package com.example.project.domain;

import java.util.Date;

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
@Table(name = "CustomerOrder")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer orderId;

    @Column(name = "OrderDate", columnDefinition = "datetime default getdate()", nullable = false)
    private Date orderDate;

    @Column(name = "OrderNumber", length = 10, nullable = true, columnDefinition = "nvarchar")
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customerId;

    @Column(name = "TotalAmount", nullable = true, columnDefinition = "decimal(12,2) default 0")
    private Double totalAmount;
}
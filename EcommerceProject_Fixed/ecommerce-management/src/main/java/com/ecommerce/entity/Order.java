package com.ecommerce.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "date")
    private Date date;

    // Constructor, getters, and setters
    public Order() {}

    public Order(Customer customer, double totalPrice, Date date) {
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.date = date;
    }
}

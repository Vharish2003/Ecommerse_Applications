package com.example.ECommerse_Application.Entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    private Date orderDate;
    private String status;
    private Double totalAmount;

    // Getters and Setters
    public Long getId() {
        return order_id;
    }

    public void setId(Long id) {
        this.order_id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order [id=" + order_id + ", orderDate=" + orderDate + ", status=" + status
                + ", totalAmount=" + totalAmount + "]";
    }

    public Order(Long id, User user, Date orderDate, String status, Double totalAmount) {
        this.order_id = id;
        this.user = user;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public Order() {
    }
}

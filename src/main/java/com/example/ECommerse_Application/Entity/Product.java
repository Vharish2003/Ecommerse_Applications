package com.example.ECommerse_Application.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    private String productName;
    private String description;
    private Double price;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    @JsonManagedReference
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private Set<Review> reviews;

    @ManyToMany(mappedBy = "product")
    @JsonManagedReference
    private Set<CartItem> cartItems;

    // Getters and Setters
    public Long getId() {
        return product_id;
    }

    public void setId(Long id) {
        this.product_id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Product [id=" + product_id + ", productName=" + productName + ", description=" + description + ", price="
                + price + ", stock=" + stock + ", seller=" + seller + ", category=" + category + ", reviews=" + reviews
                + ", cartItems=" + cartItems + ", getId()=" + getId() + ", getProductName()=" + getProductName()
                + ", getDescription()=" + getDescription() + ", getPrice()=" + getPrice() + ", getStock()=" + getStock()
                + ", getSeller()=" + getSeller() + ", getCategory()=" + getCategory() + ", getReviews()=" + getReviews()
                + ", getCartItems()=" + getCartItems() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

    public Product(Long id, String productName, String description, Double price, Integer stock, Seller seller,
                   Category category, Set<Review> reviews, Set<CartItem> cartItems) {
        super();
        this.product_id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.seller = seller;
        this.category = category;
        this.reviews = reviews;
        this.cartItems = cartItems;
    }

    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }
}

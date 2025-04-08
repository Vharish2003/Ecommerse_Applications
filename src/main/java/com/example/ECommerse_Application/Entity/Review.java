package com.example.ECommerse_Application.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    private Integer rating;
    private String comment;
    private Date createdAt;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", product=" + product + ", user=" + user + ", rating=" + rating + ", comment="
				+ comment + ", createdAt=" + createdAt + ", getId()=" + getId() + ", getProduct()=" + getProduct()
				+ ", getUser()=" + getUser() + ", getRating()=" + getRating() + ", getComment()=" + getComment()
				+ ", getCreatedAt()=" + getCreatedAt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public Review(Long id, Product product, User user, Integer rating, String comment, Date createdAt) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
		this.rating = rating;
		this.comment = comment;
		this.createdAt = createdAt;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}

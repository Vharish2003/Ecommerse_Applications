package com.example.ECommerse_Application.Entity;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String username;
    private String email;
    private String password;
    private int phoneno;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Order> orders;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Cart> carts;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Review> reviews;
    
	public Long getId() {
		return user_id;
	}

	public void setId(Long id) {
		this.user_id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "User [id=" + user_id + ", userName=" + username + ", email=" + email + ", password=" + password
				+ ", phoneno=" + phoneno + ", orders=" + orders + ", carts=" + carts + ", reviews=" + reviews
				+ ", getId()=" + getId() + ", getUserName()=" + getUserName() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getPhoneno()=" + getPhoneno() + ", getOrders()=" + getOrders()
				+ ", getCarts()=" + getCarts() + ", getReviews()=" + getReviews() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public User(Long id, String userName, String email, String password, int phoneno, Set<Order> orders,
			Set<Cart> carts, Set<Review> reviews) {
		super();
		this.user_id = id;
		this.username = userName;
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
		this.orders = orders;
		this.carts = carts;
		this.reviews = reviews;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}

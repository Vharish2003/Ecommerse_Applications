package com.example.ECommerse_Application.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "cart")
    @JsonManagedReference
    private Set<CartItem> cartItems;



	public Long getId() {
		return cart_id;
	}

	public void setId(Long id) {
		this.cart_id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Cart [id=" + cart_id + ", user=" + user + ", cartItems=" + cartItems + ", getId()=" + getId()
				+ ", getUser()=" + getUser() + ", getCartItems()=" + getCartItems() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Cart(Long id, User user, Set<CartItem> cartItems) {
		super();
		this.cart_id = id;
		this.user = user;
		this.cartItems = cartItems;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}

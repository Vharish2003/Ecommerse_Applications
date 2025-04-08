package com.example.ECommerse_Application.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seller_id;
    private String sellerName;
    private String email;

    @OneToMany(mappedBy = "seller")
    @JsonManagedReference
    private Set<Product> products;

	public Long getId() {
		return seller_id;
	}

	public void setId(Long id) {
		this.seller_id = id;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Seller [id=" + seller_id + ", sellerName=" + sellerName + ", email=" + email + ", products=" + products
				+ ", getId()=" + getId() + ", getSellerName()=" + getSellerName() + ", getEmail()=" + getEmail()
				+ ", getProducts()=" + getProducts() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Seller(Long id, String sellerName, String email, Set<Product> products) {
		super();
		this.seller_id = id;
		this.sellerName = sellerName;
		this.email = email;
		this.products = products;
	}

	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}

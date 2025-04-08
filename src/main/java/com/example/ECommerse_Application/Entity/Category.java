package com.example.ECommerse_Application.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private Set<Product> products;

	public Long getId() {
		return category_id;
	}

	public void setId(Long id) {
		this.category_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [id=" + category_id + ", name=" + name + ", products=" + products + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getProducts()=" + getProducts() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Category(Long id, String name, Set<Product> products) {
		super();
		this.category_id = id;
		this.name = name;
		this.products = products;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}

package com.example.ECommerse_Application.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ECommerse_Application.Entity.Cart;
import com.example.ECommerse_Application.Entity.Customers;
import com.example.ECommerse_Application.Repository.CartRepository;
import com.example.ECommerse_Application.Repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }
    
    public Customers saveuser(Customers customer) {
    	return customerRepository.save(customer);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
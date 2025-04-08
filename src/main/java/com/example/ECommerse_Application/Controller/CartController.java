package com.example.ECommerse_Application.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ECommerse_Application.Entity.Cart;
import com.example.ECommerse_Application.Entity.Customers;
import com.example.ECommerse_Application.Service.CartService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;
    
   

    @GetMapping("all")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        Optional<Cart> cart = cartService.getCartById(id);
        return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("post")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }
    
    @PostMapping("saving")
    public Customers save(@RequestBody Customers customer) {
    	return cartService.saveuser(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cartDetails) {
        Optional<Cart> optionalCart = cartService.getCartById(id);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cart.setUser(cartDetails.getUser());
            return ResponseEntity.ok(cartService.saveCart(cart));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
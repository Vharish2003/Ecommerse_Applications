package com.example.ECommerse_Application.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ECommerse_Application.Entity.CartItem;
import com.example.ECommerse_Application.Service.CartItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartitems")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("all")
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id) {
        Optional<CartItem> cartItem = cartItemService.getCartItemById(id);
        return cartItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("post")
    public CartItem createCartItem(@RequestBody CartItem cartItem) {
        return cartItemService.saveCartItem(cartItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable Long id, @RequestBody CartItem cartItemDetails) {
        Optional<CartItem> optionalCartItem = cartItemService.getCartItemById(id);
        if (optionalCartItem.isPresent()) {
            CartItem cartItem = optionalCartItem.get();
            cartItem.setCart(cartItemDetails.getCart());
            cartItem.setProduct(cartItemDetails.getProduct());
            cartItem.setQuantity(cartItemDetails.getQuantity());
            return ResponseEntity.ok(cartItemService.saveCartItem(cartItem));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
}
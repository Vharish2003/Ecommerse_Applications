package com.example.ECommerse_Application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ECommerse_Application.Entity.CartItem;
import com.example.ECommerse_Application.Repository.CartItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public Optional<CartItem> getCartItemById(Long id) {
        return cartItemRepository.findById(id);
    }

    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}
package com.example.ECommerse_Application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ECommerse_Application.Entity.Seller;
import com.example.ECommerse_Application.Repository.SellerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Optional<Seller> getSellerById(Long id) {
        return sellerRepository.findById(id);
    }

    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }
}
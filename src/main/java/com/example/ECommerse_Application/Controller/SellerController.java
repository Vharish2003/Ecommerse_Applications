package com.example.ECommerse_Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ECommerse_Application.Entity.Seller;
import com.example.ECommerse_Application.Service.SellerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("GetAll")
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) {
        Optional<Seller> seller = sellerService.getSellerById(id);
        return seller.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("post")
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.saveSeller(seller);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller sellerDetails) {
        Optional<Seller> optionalSeller = sellerService.getSellerById(id);
        if (optionalSeller.isPresent()) {
            Seller seller = optionalSeller.get();
            seller.setSellerName(sellerDetails.getSellerName());
            seller.setEmail(sellerDetails.getEmail());
            return ResponseEntity.ok(sellerService.saveSeller(seller));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
        return ResponseEntity.noContent().build();
    }
}
package com.example.ECommerse_Application.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ECommerse_Application.Entity.Product;
import com.example.ECommerse_Application.Service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Optional<Product> optionalProduct = productService.getProductById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setProductName(productDetails.getProductName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            product.setStock(productDetails.getStock());
            product.setSeller(productDetails.getSeller());
            product.setCategory(productDetails.getCategory());
            return ResponseEntity.ok(productService.saveProduct(product));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.ECommerse_Application.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ECommerse_Application.Entity.Category;
import com.example.ECommerse_Application.Service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = categoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("post")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        Optional<Category> optionalCategory = categoryService.getCategoryById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setName(categoryDetails.getName());
            return ResponseEntity.ok(categoryService.saveCategory(category));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
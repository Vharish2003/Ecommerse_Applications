package com.example.ECommerse_Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ECommerse_Application.Entity.Review;
import com.example.ECommerse_Application.Service.ReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("all")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("post")
    public Review createReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
        Optional<Review> optionalReview = reviewService.getReviewById(id);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            review.setRating(reviewDetails.getRating());
            review.setComment(reviewDetails.getComment());
            review.setProduct(reviewDetails.getProduct());
            review.setUser(reviewDetails.getUser());
            return ResponseEntity.ok(reviewService.saveReview(review));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
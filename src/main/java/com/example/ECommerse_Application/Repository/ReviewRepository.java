package com.example.ECommerse_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ECommerse_Application.Entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}

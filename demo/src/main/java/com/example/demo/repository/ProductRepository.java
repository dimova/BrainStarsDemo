package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long> {
        @Query("SELECT p.category, COUNT(p.category) FROM Product AS p GROUP BY p.category ORDER BY p.category DESC")
        Optional<Product> findAllbyCategory(String category);
}

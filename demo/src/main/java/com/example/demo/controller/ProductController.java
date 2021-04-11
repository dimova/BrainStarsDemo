package com.example.demo.controller;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> list = service.getAllProducts();

        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Product entity = service.getProductById(id);

        return new ResponseEntity<Product>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<Product> getProductByCategory(@PathVariable("category") String category)
            throws RecordNotFoundException {
        Product entity = service.getProductByCategory(category);

        return new ResponseEntity<Product>(entity, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Product> createOrUpdateProduct(Product product)
            throws RecordNotFoundException {
        Product updated = service.createOrUpdateProduct(product);
        return new ResponseEntity<Product>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteProductById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteProductById(id);
        return HttpStatus.FORBIDDEN;
    }


}

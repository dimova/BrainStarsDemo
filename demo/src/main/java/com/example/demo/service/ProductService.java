package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> getAllProducts() {
        List<Product> productList = repository.findAll();

        if (productList.size() > 0) {
            return productList;
        } else {
            return new ArrayList<Product>();
        }
    }

    public Product getProductById(Long id) throws RecordNotFoundException {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("No product exist for given id");
        }
    }

    public Product getProductByCategory(String category) throws RecordNotFoundException {
        Optional<Product> product = repository.findAllbyCategory(category);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("No category exist for given name");
        }
    }

    public Product createOrUpdateProduct(Product entity) throws RecordNotFoundException {
        Optional<Product> product = repository.findById(entity.getId());

        if (product.isPresent()) {
            Product newEntity = product.get();

            newEntity.setName(entity.getName());
            newEntity.setCategory(entity.getCategory());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteProductById(Long id) throws RecordNotFoundException {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}

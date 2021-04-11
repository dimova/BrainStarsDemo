package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {
    @Autowired
    OrderRepository repository;

    public List<Order> getAllOrders() {
        List<Order> orderList = repository.findAll();

        if (orderList.size() > 0) {
            return orderList;
        } else {
            return new ArrayList<Order>();
        }
    }

    public Order getOrderById(Long id) throws RecordNotFoundException {
        Optional<Order> order = repository.findById(id);

        if (order.isPresent()) {
            return order.get();
        } else {
            throw new RecordNotFoundException("No order exist for given id");
        }
    }

    public Order createOrUpdateOrder(Order entity) throws RecordNotFoundException {
        Optional<Order> order = repository.findById(entity.getId());

        if (order.isPresent()) {
            Order newEntity = order.get();

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }

    }
}

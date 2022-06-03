package com.grupo3.consumer.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo3.consumer.model.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {
    public Optional<Order> findById(Integer id);
}

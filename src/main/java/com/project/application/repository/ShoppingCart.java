package com.project.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.application.model.Product;

public interface ShoppingCart extends JpaRepository<Product, Long> {

}

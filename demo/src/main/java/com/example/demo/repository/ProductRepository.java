package com.example.demo.repository;

import com.example.demo.entity.Product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Long> {
    

    List<Product> findAll();

}


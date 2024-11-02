package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserEntity;


// https://www.youtube.com/watch?v=JFTpzy7gsg0&list=PLJkjrxxiBSFCcOjy0AAVGNtIa08VLk1EJ&index=5
// 참고 자료 test
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
}
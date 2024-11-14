package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Shoppingcart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 명시
    private int cartid ;
    
    private int productid ;
    private int id ;

}

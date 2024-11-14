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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productid ; 


    private int id ;
    private String name ;
    private String description ;
    private String price ;

    private String status ;
    private String imageurl ; // ?


    private String createdday ;
    private String updateday ;

    private int categoryid ;
    
}

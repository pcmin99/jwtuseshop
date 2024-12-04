package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productid ; 


    private String name ;
    private String description ;
    private String price ;

    private int count ;
    private String imageurl ; // ?


    private String createdday ;
    private String updateday ;


    @ManyToOne
    @JoinColumn(name = "categoryid") // 외래 키로 매핑
    private Categories category;

    
}

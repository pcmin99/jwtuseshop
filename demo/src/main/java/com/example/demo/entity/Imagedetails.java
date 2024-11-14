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
public class Imagedetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imagedetailid ;

    private int productid ;
    private int imageid ;
    
}

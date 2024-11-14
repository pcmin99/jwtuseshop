package com.example.demo.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Chat {
    
    private int id ;  // 채팅 번호 id 아님
    private int alertid ;
    private String message ;

    private String date ;
}

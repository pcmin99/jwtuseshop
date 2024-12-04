package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Product;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.ProductService;
import com.example.demo.service.CustomUserDetailsService;

@Controller
public class AdminController {



    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private ProductService productService ; 
    

    @GetMapping("/admin")
    public String adminP(){

        return "admin";
    }
    // @GetMapping("/hello") // 채팅 mapping
    // public String hello () {
    //     return "main2";
    // }

    @GetMapping("/admin/index") // 관리자 첫 화면 mapping
    public String hello1 () {
        return "admin/index";
    }


    @GetMapping("/admin/tables") // 관리자 테이블 관련 mapping
    public String tabledashboard(Model model){
        List<UserEntity> userList = customUserDetailsService.getAllUsers();
        model.addAttribute("users", userList);

        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productLists", productList);

        

        return "admin/tables";
    }


    @GetMapping("/admin/notifications") // 관리자 알람 관련 mapping
    public String tabledashboard1(){
        return "admin/notifications";
    }


}
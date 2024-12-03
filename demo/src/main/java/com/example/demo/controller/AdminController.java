package com.example.demo.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Categories;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CustomUserDetailsService;

@Controller
public class AdminController {



    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private CategoryService categoryService ; 
    

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

        List<Categories> categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryLists", categoryList);

        

        return "admin/tables";
    }


    @GetMapping("/admin/notifications") // 관리자 알람 관련 mapping
    public String tabledashboard1(){
        return "admin/notifications";
    }


}
package com.example.demo.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
//@ResponseBody
public class MainController {
    

    @GetMapping("/")
    public String mainP(){

        String username = SecurityContextHolder.getContext().getAuthentication().getName() ; 

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();

        return "main Controller:" + username + role;
        
    }



    @GetMapping("/hello") // 채팅 mapping
    public String hello () {
        return "main2";
    }

    @GetMapping("/hello1") // 관리자 첫 화면 mapping
    public String hello1 () {
        return "index";
    }


    @GetMapping("/admin/tables") // 관리자 테이블 관련 mapping
    public String tabledashboard(){
        return "admin/tables";
    }


    @GetMapping("/admin/notifications") // 관리자 알람 관련 mapping
    public String tabledashboard1(){
        return "admin/notifications";
    }






}
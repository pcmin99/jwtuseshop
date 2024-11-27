package com.example.demo.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {
    

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
    public String tabledashboard(){
        return "admin/tables";
    }


    @GetMapping("/admin/notifications") // 관리자 알람 관련 mapping
    public String tabledashboard1(){
        return "admin/notifications";
    }


}
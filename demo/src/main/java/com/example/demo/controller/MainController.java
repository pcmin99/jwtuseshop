package com.example.demo.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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
        
        System.out.println(username);
        System.out.println(role);
        
        return role + "/index" ;
    }



    // @PostMapping("/login")
    // public void login11(){

    // }



    // @GetMapping("/hello") // 채팅 mapping
    // public String hello () {
    //     return "main2";
    // }

    @GetMapping("/loginandjoin/login")  // 로그인 페이지 로드
    public String loginPage() {
        return "loginandjoin/login";
    }


    @GetMapping("/index") // 
    public String hello1 () {

        return "index";
    }


    // @GetMapping("/admin/tables") // 관리자 테이블 관련 mapping
    // public String tabledashboard(){
    //     return "admin/tables";
    // }

    @GetMapping("/user/shop-grid")
    public String shopGrid(){

        return "user/shop-grid";
    }


    @GetMapping("/user/shop-details") // 제품 상세 페이지
    public String shopDetail(){
        return "user/shop-details";
    }

    @GetMapping("/user/shoping-cart") // 장바구니 페이지 
    public String shopingCart(){

        return "user/shoping-cart";
    }

    @GetMapping("/user/contact") // 문의 및 정보 등등
    public String contact(){

        return "user/contact";
    }

    @GetMapping("/user/checkout") // 제품 주문 ( 배송지 입력, 번호 입력 등등 )
    public String checkout(){

        return "user/checkout";
    }

    @GetMapping("/user/blog") // 블로그 리스트 페이지
    public String blog(){

        return "user/blog";
    }

    @GetMapping("/user/blog-details") // 블로그 상세 페이지
    public String blogDetails(){

        return "user/blog-details";
    }


    @GetMapping("/user/chat")
    public String chat(Model model) {
        model.addAttribute("jwtToken", "Bearer your-jwt-token"); // 클라이언트용 JWT 토큰 제공
        return "user/chat";
    }




    // @GetMapping("/admin/notifications") // 관리자 알람 관련 mapping
    // public String tabledashboard1(){
    //     return "admin/notifications";
    // }






}
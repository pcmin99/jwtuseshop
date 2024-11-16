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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@ResponseBody
public class MainController {
    

    @GetMapping("/")
    public String mainP(){

        // String username = SecurityContextHolder.getContext().getAuthentication().getName() ; 

        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        // Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        // GrantedAuthority auth = iter.next();
        // String role = auth.getAuthority();

        //return "main Controller:" + username + role;
        return "main Controller:" ;
        
    }


    // @GetMapping("/main2")
    // public ModelAndView  main2(){
    //     ModelAndView  ModelAndView = new ModelAndView("main2");
    //     return ModelAndView  ;
    // }

    @GetMapping("/main21")
    public String main2() {
    return "main2" ;
    }

}
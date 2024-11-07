package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.JoinDTO;
import com.example.demo.service.JoinService;

@Controller
@ResponseBody
public class JoinController {
    
    private final JoinService joinService ;
    
    // 보통 @Autowired를 사용해도 되지만 주입 방식 작성을 선호한다 
    public JoinController(JoinService joinService){

        this.joinService = joinService ; 
    }


    @PostMapping("/join")
    public String joinProcess(JoinDTO joinDTO){

        joinService.joinProcess(joinDTO);

        return "ok";
    }

}

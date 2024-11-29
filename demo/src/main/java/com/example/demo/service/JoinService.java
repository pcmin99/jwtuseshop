package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.JoinDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class JoinService {

    private final UserRepository userRepository ;

    private final BCryptPasswordEncoder bCryptPasswordEncoder ;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){

        this.userRepository = userRepository ; 
        this.bCryptPasswordEncoder = bCryptPasswordEncoder ; 

    }

    

    public void joinProcess(JoinDTO joinDTO){

        String username = joinDTO.getUsername() ;
        String password = joinDTO.getPassword() ;
        
        Boolean isExist = userRepository.existsByUsername(username);
        if(isExist){
            return ;
        }

        UserEntity data = new UserEntity();
        
        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_USER");

        userRepository.save(data);

    }
    
}

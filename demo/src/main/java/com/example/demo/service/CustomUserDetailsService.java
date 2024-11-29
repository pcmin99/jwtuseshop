package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomUserDetails;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {

				//DB에서 조회
                UserEntity userData = userRepository.findByUsername(username);

                if (userData != null) {
                                
                                //UserDetails에 담아서 return하면 AutneticationManager가 검증 함
                    return new CustomUserDetails(userData);
                }
        
                return null;
            }
    
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }


}

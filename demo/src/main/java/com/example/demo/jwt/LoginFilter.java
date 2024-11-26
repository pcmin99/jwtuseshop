package com.example.demo.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.dto.CustomUserDetails;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;
  private final JWTUtil jwtUtil;

  public LoginFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {

      this.authenticationManager = authenticationManager;
      this.jwtUtil = jwtUtil;
      
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

    String username = obtainUsername(request);
    String password = obtainPassword(request);


      UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, null);

      return authenticationManager.authenticate(authToken);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {


      CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

      String username = customUserDetails.getUsername();

      Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
      Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
      GrantedAuthority auth = iterator.next();

      String role = auth.getAuthority();

      String token = jwtUtil.createJwt(username, role, 60*60*1000L*1);

      Cookie cookie = new Cookie("JWT_TOKEN", token);
      cookie.setHttpOnly(true); // XSS 보호
      cookie.setPath("/"); // 모든 경로에 적용
      cookie.setHttpOnly(true);
      response.addCookie(cookie);
      response.addCookie(cookie);

    // Authorization 헤더에 토큰 추가
    response.addHeader("Authorization", "Bearer " + token);

     // 권한에 따라 리다이렉트 URL 설정
     String redirectUrl = "/index";  // 기본 사용자 페이지
     if ("ROLE_ADMIN".equals(role)) {
         redirectUrl = "/admin/index";
     }
 
     response.sendRedirect(redirectUrl);
 
  }

  @Override
  protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {

      response.setStatus(401);
  }
}
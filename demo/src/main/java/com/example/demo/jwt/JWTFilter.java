package com.example.demo.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.dto.CustomUserDetails;
import com.example.demo.entity.UserEntity;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    public JWTFilter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        

        String path = request.getRequestURI();

        // 'join' 경로는 JWT 인증을 건너뛰도록 설정
        if (path.startsWith("/join")) {
            filterChain.doFilter(request, response);  // JWT 필터를 건너뛰고 요청을 그대로 전달
            return;
        }
    

        
        // Authorization 헤더에서 토큰 추출
        String authorization = request.getHeader("Authorization");

        // Authorization 헤더가 없거나 'Bearer '로 시작하지 않는 경우
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            // 토큰이 없으면 요청을 계속 처리
            filterChain.doFilter(request, response);
            return;
        }

        // 'Bearer ' 부분을 제거하고 토큰만 추출
        String token = authorization.split(" ")[1];

        // 토큰이 만료되었으면, 401 상태 코드로 응답하고 종료
        if (jwtUtil.isExpired(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token has expired");
            return;
        }

        // 토큰에서 사용자 정보(username, role) 추출
        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        // UserEntity를 생성하여 사용자 정보를 설정
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setRole(role);

        // CustomUserDetails 객체 생성
        CustomUserDetails customUserDetails = new CustomUserDetails(userEntity);

        // Spring Security 인증 토큰 생성
        Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());

        // SecurityContext에 인증 정보 설정
        SecurityContextHolder.getContext().setAuthentication(authToken);

        // 후속 필터로 요청 전달
        // 인증 후 더 이상 다른 인증 필터가 실행되지 않도록 설정
        filterChain.doFilter(request, response);
    }
}

package com.example.demo.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

    //JWT 서명에 사용될 scretKey (application.properties에 설정)
    private final SecretKey secretKey;


    public JWTUtil(@Value("${spring.jwt.secret}") String secret) {
        this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), SignatureAlgorithm.HS256.getJcaName());
    }

    //JWt에서 'username' 클레임을 추출하는 메서드
    public String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token) //토큰을 파싱하고 검증
                .getBody()              // 페이로드 클레임을 추출
                .get("username", String.class); // username 클레임 추출
    }

    public String getRole(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class); // role 클레임 추출
    }
    // 토큰 만료 여부를 확인하는 메서드
    public Boolean isExpired(String token) {
        Date expiration = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();   // 토큰 만료 시간 추출
        return expiration != null && expiration.before(new Date()); // 토큰 만료 시간 확인
    }

    // 새로운 Jwt 토큰 생성
    public String createJwt(String username, String role, Long expiredMs) {
        return Jwts.builder()
                .claim("username", username)
                .claim("role", role)
                .setIssuedAt(new Date(System.currentTimeMillis())) // 발급 시간 설정
                .setExpiration(new Date(System.currentTimeMillis() + expiredMs)) // 만료 시간 설정
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact(); // JWT 토큰 생성
    }
}

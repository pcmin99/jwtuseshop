package com.example.demo.interceptor;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class WebSocketJwtInterceptor implements ChannelInterceptor {

    private final SecretKey secretKey ; 

        // SecretKey를 안전하게 주입하거나 생성하는 방법
        public WebSocketJwtInterceptor() {
            // 예시로 하드코딩된 값을 사용하는 경우
            String secret = "your-secret-key"; // 실제로는 환경변수나 다른 안전한 방식으로 관리해야 합니다.
            this.secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256"); // 또는 적합한 알고리즘 사용
        }

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);

        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            String token = accessor.getFirstNativeHeader("Authorization");

            if (token == null || !validateToken(token)) {
                throw new IllegalArgumentException("Invalid JWT Token");
            }
        }

        return message;
    }

    private boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();
            return claims != null;
        } catch (Exception e) {
            return false;
        }
    }
}

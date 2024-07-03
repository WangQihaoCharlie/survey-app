package com.lepton.surveyauth.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret; // 密钥

    @Value("${jwt.expiration}")
    private Long expiration; // Token 过期时间，单位毫秒

    // 生成 JWT Token
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);


        return Jwts.builder()
                .issuedAt(now)
                .subject(username)
                .expiration(expiryDate)
                .signWith(getSecretKey())
                .compact();
    }

    // 解析 JWT Token
    public Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token);
    }

    // 从 JWT Token 中获取用户名
    public String getUsernameFromToken(String token) {
        return parseToken(token).getPayload().getSubject();
    }

    // 获取 SecretKey
    private SecretKey getSecretKey() {
        // 使用 Keys 提供的方法生成密钥
        byte[] keyBytes = secret.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // 验证 JWT Token 是否有效
    public boolean validateToken(String authToken) {
        try {
            parseToken(authToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

package com.AuthService.Security;

import org.springframework.stereotype.Component;

import com.AuthService.Model.User;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.AuthService.Model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(User user) {

        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()
                .setSubject(user.getUsername()) // username
                .claim("role", user.getRole().name()) // custom claim
                .setIssuedAt(new Date()) // token created time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiry
                .signWith(key, SignatureAlgorithm.HS256) // sign token
                .compact(); // generate final token
    }
}
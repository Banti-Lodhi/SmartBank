package com.SmartBank.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    private final String secretKey = "smart_bank_smart_bank_smart_bank"; // should be at least 256-bit (for HS256)

    // You can also use a SecretKey if you want to make it more secure
    private final SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}


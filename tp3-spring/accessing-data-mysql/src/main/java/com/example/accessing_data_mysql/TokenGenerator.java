package com.example.accessing_data_mysql;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class TokenGenerator {

    private static final String SECRET =
            "my-super-secret-key-my-super-secret-key"; // >= 32 chars

    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateJwtToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(KEY)
                .compact();
    }
}
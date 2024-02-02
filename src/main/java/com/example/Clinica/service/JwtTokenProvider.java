package com.example.Clinica.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

    @Service
    public class JwtTokenProvider {

        private static final String SECRET_KEY = "123456";
        private static final long EXPIRATION_TIME = 30 * 24 * 60 * 60 * 1000;

        public String generateToken(UserDetails userDetails) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("role", userDetails.getAuthorities().iterator().next().getAuthority());

            return Jwts.builder()
                    .setSubject(userDetails.getUsername())
                    .setClaims(claims)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();
        }
    }

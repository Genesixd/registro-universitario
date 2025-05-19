package com.universidad.registro.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "clave-secreta-super-larga-para-jwt-de-genex"; // Mínimo 256 bits
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 6; // 6 horas

    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String username, String rol) {
    return Jwts.builder()
            .setSubject(username)                       // ✅ Correcto
            .claim("rol", rol)
            .setIssuedAt(new Date())                    // ✅ Correcto
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // ✅ Correcto
            .signWith(getKey(), SignatureAlgorithm.HS256)
            .compact();
}


    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String getRolFromToken(String token) {
        return (String) Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("rol");
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}

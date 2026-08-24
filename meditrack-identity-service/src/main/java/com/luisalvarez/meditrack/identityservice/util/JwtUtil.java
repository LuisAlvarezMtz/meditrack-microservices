package com.luisalvarez.meditrack.identityservice.util;

import com.luisalvarez.meditrack.identityservice.entity.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final long TIME_EXP = 1000*60*60;
    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public String generateToken(UserPrincipal userPrincipal){
        return Jwts.builder()
                .subject(userPrincipal.getUsername())
                .claim("role", userPrincipal.getRole().name())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+TIME_EXP))
                .signWith(privateKey, Jwts.SIG.RS256)
                .compact();
    }

    public String extractUsername(String token){
        return extractClaims(token).getSubject();
    }

    public String extractRole(String token){
        return extractClaims(token).get("role", String.class);
    }

    public boolean isTokenExpired(String token){
        return extractClaims(token).getExpiration().before(new Date());
    }

    private Claims extractClaims(String token) {
       return Jwts.parser()
               .verifyWith(publicKey)
               .build()
               .parseSignedClaims(token)
               .getPayload();
    }

    public boolean validateToken(String username, UserDetails userDetails, String token) {
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
}

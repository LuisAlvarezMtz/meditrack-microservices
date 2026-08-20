package com.luisalvarez.meditrack.identityservice.util;

import com.luisalvarez.meditrack.identityservice.entity.UserPrincipal;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JWTUtil {

    private final long TIME_EXP = 1000*60*60;
    private final PrivateKey privateKey;

    public String generateToken(UserPrincipal userPrincipal){
        return Jwts.builder()
                .subject(userPrincipal.getUsername())
                .claim("role", userPrincipal.getRole().name())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+TIME_EXP))
                .signWith(privateKey, Jwts.SIG.RS256)
                .compact();
    }

}

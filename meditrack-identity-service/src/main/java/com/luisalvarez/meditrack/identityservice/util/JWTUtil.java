package com.luisalvarez.meditrack.identityservice.util;

import com.luisalvarez.meditrack.identityservice.DTO.UserRequestDto;
import com.luisalvarez.meditrack.identityservice.entity.Role;
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

    public String generateToken(UserRequestDto userRequestDto){
        return Jwts.builder()
                .subject(userRequestDto.email())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+TIME_EXP))
                .signWith(privateKey, Jwts.SIG.RS256)
                .compact();
    }

}

package com.luisalvarez.meditrack.identityservice.controller;

import com.luisalvarez.meditrack.identityservice.DTO.UserRequestDto;
import com.luisalvarez.meditrack.identityservice.entity.UserPrincipal;
import com.luisalvarez.meditrack.identityservice.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/identity")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<String> generateToken(@RequestBody UserRequestDto userRequestDto) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken
                            (userRequestDto.email(), userRequestDto.password())

            );
            UserPrincipal principal = (UserPrincipal) auth.getPrincipal();

            Assert.notNull(principal, "Authentication principal must not be null");

            String token = jwtUtil.generateToken(principal);
            return ResponseEntity.ok(token);
        }
        catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}

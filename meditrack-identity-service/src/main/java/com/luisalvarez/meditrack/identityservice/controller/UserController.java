package com.luisalvarez.meditrack.identityservice.controller;

import com.luisalvarez.meditrack.identityservice.DTO.UserRequestDto;
import com.luisalvarez.meditrack.identityservice.service.UserService;
import com.luisalvarez.meditrack.identityservice.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/identity")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody UserRequestDto userRequestDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken
                            (userRequestDto.email(), userRequestDto.password())

            );
            return jwtUtil.generateToken(userRequestDto);
        } catch (Exception e) {
            throw e;
        }
    }
}

package com.luisalvarez.meditrack.identityservice.controller;

import com.luisalvarez.meditrack.identityservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/identity")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String hello(Authentication authentication){
        return "Hello: " + authentication.getName();
    }

    @GetMapping("/user")
    public String saveUser(){
        userService.registerUser();
        return "User saved";
    }

}

package com.luisalvarez.meditrack.identityservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/identity")
public class IdentityController {

    @GetMapping
    public String hello(){
        return "Hello World";
    }

}

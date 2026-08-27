package com.luisalvarez.meditrack.identityservice.controller;

import com.luisalvarez.meditrack.identityservice.dto.PatientRegistrationRequest;
import com.luisalvarez.meditrack.identityservice.dto.PatientRegistrationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/register")
public class RegistrationController {

    @PostMapping("/patient")
    public ResponseEntity<PatientRegistrationResponse> registerPatient
            (@RequestBody PatientRegistrationRequest request){

        return null;
    }
}

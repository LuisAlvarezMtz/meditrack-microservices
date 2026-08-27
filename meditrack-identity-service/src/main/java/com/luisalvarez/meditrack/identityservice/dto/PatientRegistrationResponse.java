package com.luisalvarez.meditrack.identityservice.dto;

import com.luisalvarez.meditrack.identityservice.entity.Role;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record PatientRegistrationResponse(
        UUID patientId,
        String email,
        Role role,
        String firstName,
        String lastName,
        LocalDate birthDay,
        String phone,
        Instant cratedAt
) {
}

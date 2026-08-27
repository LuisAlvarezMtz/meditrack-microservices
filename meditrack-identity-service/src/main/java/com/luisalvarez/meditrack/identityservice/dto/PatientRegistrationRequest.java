package com.luisalvarez.meditrack.identityservice.dto;

import java.time.LocalDate;

public record PatientRegistrationRequest(
        String email,
        String password,
        String firstName,
        String lastName,
        LocalDate birthDay,
        String phone
) {
}

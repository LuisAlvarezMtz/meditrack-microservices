package com.luisalvarez.meditrack.identityservice.DTO;

import com.luisalvarez.meditrack.identityservice.entity.Role;

public record UserRequestDto(String email, String password) {}

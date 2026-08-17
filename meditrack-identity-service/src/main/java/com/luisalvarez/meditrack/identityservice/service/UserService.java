package com.luisalvarez.meditrack.identityservice.service;

import com.luisalvarez.meditrack.identityservice.entity.Role;
import com.luisalvarez.meditrack.identityservice.entity.User;
import com.luisalvarez.meditrack.identityservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(){
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword(passwordEncoder.encode("test"));
        user.setRole(Role.PATIENT);
        userRepository.save(user);
    }

}

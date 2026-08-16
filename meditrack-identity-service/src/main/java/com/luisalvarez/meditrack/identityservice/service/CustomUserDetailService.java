package com.luisalvarez.meditrack.identityservice.service;

import com.luisalvarez.meditrack.identityservice.entity.User;
import com.luisalvarez.meditrack.identityservice.entity.UserPrincipal;
import com.luisalvarez.meditrack.identityservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class  CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("Username not found"));

        return new UserPrincipal(user);

    }
}

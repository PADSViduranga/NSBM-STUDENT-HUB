package com.example.NSBM.student.hub.service;

import com.example.NSBM.student.hub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) {

        // 👇 FORCE YOUR ENTITY USER
        com.example.NSBM.student.hub.model.User user =
                repo.findByUsername(username)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(
                        user.getRoles()
                                .stream()
                                .map(role -> role.getName())
                                .toArray(String[]::new)
                )
                .build();
    }
}

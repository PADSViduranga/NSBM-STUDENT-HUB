package com.example.NSBM.student.hub.model;

import com.example.NSBM.student.hub.repository.RoleRepository;
import com.example.NSBM.student.hub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserRegistration {


    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private PasswordEncoder encoder;


    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Role role = roleRepo.findByName("ROLE_ADMIN").orElseThrow();
        user.getRoles().add(role);
        return userRepo.save(user);
    }
}

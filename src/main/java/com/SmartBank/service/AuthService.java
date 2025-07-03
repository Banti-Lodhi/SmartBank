package com.SmartBank.service;

import com.SmartBank.dto.LoginDto;
import com.SmartBank.model.User;
import com.SmartBank.repository.UserRepository;
import com.SmartBank.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
   private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String logined(LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(), loginDto.getPassword()
                )
        );
        Optional<User> user = userRepository.findByEmail(loginDto.getEmail());
return user.map(u -> jwtUtil.generateToken(u.getEmail())).
        orElseThrow(()-> new RuntimeException("Invalid Credentials"));
    }
}

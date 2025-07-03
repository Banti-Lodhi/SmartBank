package com.SmartBank.service;

import com.SmartBank.dto.UserDto;
import com.SmartBank.model.User;
import com.SmartBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private UserDto getUserDetails(String email) {
       User user = userRepository.findByEmail(email).orElseThrow();
       return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}

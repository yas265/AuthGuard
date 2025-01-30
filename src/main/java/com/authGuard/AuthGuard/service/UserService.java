package com.authGuard.AuthGuard.service;

import com.authGuard.AuthGuard.entity.User;
import com.authGuard.AuthGuard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User registerUser(User user) {

        if(userRepository.findByUserName(user.getUserName()).isPresent())
        {
            throw new RuntimeException("This user name is already registered");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleName(user.getRoleName().toUpperCase());
        return userRepository.save(user);
    }

}

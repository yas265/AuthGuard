package com.authGuard.AuthGuard.service;

import com.authGuard.AuthGuard.entity.User;
import com.authGuard.AuthGuard.exception.ResourceNotFound;
import com.authGuard.AuthGuard.repository.UserRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFound("This user is not registered in our database"));

        UserDetails customUserDetails = new CustomUserDetails(user);

        return customUserDetails;

    }
}

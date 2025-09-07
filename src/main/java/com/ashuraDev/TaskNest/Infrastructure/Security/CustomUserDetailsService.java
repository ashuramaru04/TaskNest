package com.ashuraDev.TaskNest.Infrastructure.Security;

import com.ashuraDev.TaskNest.Infrastructure.Repository.SpringDataUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final SpringDataUserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(user-> User.builder()
                .username(user.getEmail())
                .password(user.getPasswordHash())
                .roles("USER")
                .build())
                .orElseThrow(()-> new UsernameNotFoundException("User not found using email" +  email));

    }
}

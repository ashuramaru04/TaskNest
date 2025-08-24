package com.ashuraDev.TaskNest.Application.useCases;



import com.ashuraDev.TaskNest.Application.Port.Out.UserRepository;
import com.ashuraDev.TaskNest.Domain.Models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserUseCaseImpl {

    private final UserRepository userRepository;

    public User createUser(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(u -> { throw new IllegalArgumentException("Email ya registrado"); });
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}


package com.ashuraDev.TaskNest.Infrastructure.Controller;

import com.ashuraDev.TaskNest.Application.DTOs.AuthRequest;
import com.ashuraDev.TaskNest.Application.DTOs.AuthResponse;
import com.ashuraDev.TaskNest.Application.Port.Out.UserRepository;
import com.ashuraDev.TaskNest.Infrastructure.Security.JwtService;
import com.ashuraDev.TaskNest.Domain.Models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepositoryPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody AuthRequest request) {
        if (userRepositoryPort.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("❌ El usuario ya existe");
        }

        User newUser = new User();
        newUser.setName(request.getEmail().split("@")[0]); // por ahora el nombre es el email
        newUser.setEmail(request.getEmail());
        newUser.setPasswordHash(passwordEncoder.encode(request.getPassword()));

        userRepositoryPort.save(newUser);
        return ResponseEntity.ok("✅ Usuario registrado con éxito");
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody AuthRequest request) {
        return userRepositoryPort.findByEmail(request.getEmail())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPasswordHash()))
                .map(user -> {
                    String token = jwtService.generateToken(user.getEmail());
                    return ResponseEntity.ok(new AuthResponse(token));
                })
                .orElse(ResponseEntity.status(401).build());
    }
}

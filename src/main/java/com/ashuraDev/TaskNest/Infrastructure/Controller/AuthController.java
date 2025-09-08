package com.ashuraDev.TaskNest.Infrastructure.Controller;

import com.ashuraDev.TaskNest.Application.DTOs.AuthRequest;
import com.ashuraDev.TaskNest.Application.DTOs.AuthResponse;
import com.ashuraDev.TaskNest.Application.Port.Out.UserRepository;
import com.ashuraDev.TaskNest.Domain.Models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepositoryPort;
    private final PasswordEncoder passwordEncoder;

    private final String secret = "mi_clave_super_secreta_para_jwt_segura_123456789"; // 📌 Mover a application.properties
    private final long expiration = 1000 * 60 * 60; // 1 hora

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

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
                    String token = Jwts.builder()
                            .setSubject(user.getEmail())
                            .setIssuedAt(new Date())
                            .setExpiration(new Date(System.currentTimeMillis() + expiration))
                            .signWith(getSigningKey())
                            .compact();

                    return ResponseEntity.ok(new AuthResponse(token));
                })
                .orElse(ResponseEntity.status(401).build());
    }
}

package com.ashuraDev.TaskNest.Infrastructure.Controller;


import com.ashuraDev.TaskNest.Application.DTOs.UserRequestDTO;
import com.ashuraDev.TaskNest.Application.DTOs.UserResponseDTO;
import com.ashuraDev.TaskNest.Application.useCases.UserUseCaseImpl;
import com.ashuraDev.TaskNest.Domain.Models.User;
import com.ashuraDev.TaskNest.Infrastructure.Mapper.UserDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCaseImpl userUseCase;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Validated @RequestBody UserRequestDTO dto) {
            User user = UserDTOMapper.toDomain(dto);
            User saved = userUseCase.createUser(user);
        return ResponseEntity.ok(UserDTOMapper.toResponse(saved));
                }


     @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id){
        return userUseCase.getUserById(id)
                .map(UserDTOMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
     }
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll(){
        List<UserResponseDTO> users= userUseCase.getAllUsers()
                .stream()
                .map(UserDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userUseCase.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> getByEmail(@PathVariable String email) {
        return  userUseCase.getUserByEmail(email)
                .map(UserDTOMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

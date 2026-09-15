package com.unpredictableXRelations.UserAndTaskRelation.user.controller;

import com.unpredictableXRelations.UserAndTaskRelation.user.dtos.UserRequestDTO;
import com.unpredictableXRelations.UserAndTaskRelation.user.dtos.UserResponseDTO;
import com.unpredictableXRelations.UserAndTaskRelation.user.service.UserServiceHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController
{
    private final UserServiceHandler service;

    // create
    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserRequestDTO requestDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll()
    {
        return ResponseEntity.ok(service.getAllUser());
    }
}

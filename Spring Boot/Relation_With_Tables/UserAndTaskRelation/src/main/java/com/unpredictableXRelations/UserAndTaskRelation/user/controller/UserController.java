package com.unpredictableXRelations.UserAndTaskRelation.user.controller;

import com.unpredictableXRelations.UserAndTaskRelation.user.dtos.UserRequestDTO;
import com.unpredictableXRelations.UserAndTaskRelation.user.dtos.UserResponseDTO;
import com.unpredictableXRelations.UserAndTaskRelation.user.service.UserServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController
{
    private final UserServiceHandler service;

    // create end point
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO requestDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }

    // Get all
    public ResponseEntity<List<UserResponseDTO>> getAll()
    {
        return ResponseEntity.ok(service.getAllUser());
    }
}

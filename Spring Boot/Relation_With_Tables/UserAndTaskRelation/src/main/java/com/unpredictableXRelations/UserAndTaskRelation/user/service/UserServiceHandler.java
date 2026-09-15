package com.unpredictableXRelations.UserAndTaskRelation.user.service;

import com.unpredictableXRelations.UserAndTaskRelation.user.dtos.UserRequestDTO;
import com.unpredictableXRelations.UserAndTaskRelation.user.dtos.UserResponseDTO;

import java.util.List;

public interface UserServiceHandler
{
    // Create User
    UserResponseDTO create(UserRequestDTO requestDTO);
    // Get all User
    List<UserResponseDTO> getAllUser();
}

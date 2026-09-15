package com.unpredictableXRelations.UserAndTaskRelation.user.mapper;

import com.unpredictableXRelations.UserAndTaskRelation.user.dtos.UserRequestDTO;
import com.unpredictableXRelations.UserAndTaskRelation.user.dtos.UserResponseDTO;
import com.unpredictableXRelations.UserAndTaskRelation.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper
{
    // DTO -> toEntity
    public User toEntity(UserRequestDTO requestDTO)
    {
        return User.builder()
                .name(requestDTO.getName())
                .email(requestDTO.getEmail())
                .code(requestDTO.getCode())
                .build();
    }

    // Entity -> toResponse
    public UserResponseDTO toResponse(User user)
    {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .code(user.getCode())
                .build();
    }
}

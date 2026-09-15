package com.unpredictableXRelations.UserAndTaskRelation.user.service;


import com.unpredictableXRelations.UserAndTaskRelation.user.dtos.UserRequestDTO;
import com.unpredictableXRelations.UserAndTaskRelation.user.dtos.UserResponseDTO;
import com.unpredictableXRelations.UserAndTaskRelation.user.entity.User;
import com.unpredictableXRelations.UserAndTaskRelation.user.mapper.UserMapper;
import com.unpredictableXRelations.UserAndTaskRelation.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceIMP implements UserServiceHandler
{
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserResponseDTO create(UserRequestDTO requestDTO)
    {
        User user = mapper.toEntity(requestDTO);
        User savedUser = repository.save(user);
        return mapper.toResponse(savedUser);
    }

    @Override
    public List<UserResponseDTO> getAllUser()
    {
        List<User> users = repository.findAll();
        return users.stream().map(mapper::toResponse).toList();
    }
}

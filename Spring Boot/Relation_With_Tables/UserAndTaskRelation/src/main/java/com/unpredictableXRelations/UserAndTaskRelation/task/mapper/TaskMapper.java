package com.unpredictableXRelations.UserAndTaskRelation.task.mapper;

import com.unpredictableXRelations.UserAndTaskRelation.exceptions.ResourceNotFoundException;
import com.unpredictableXRelations.UserAndTaskRelation.task.dtos.TaskRequestDTO;
import com.unpredictableXRelations.UserAndTaskRelation.task.dtos.TaskResponseDTO;
import com.unpredictableXRelations.UserAndTaskRelation.task.entity.Task;
import com.unpredictableXRelations.UserAndTaskRelation.user.entity.User;
import com.unpredictableXRelations.UserAndTaskRelation.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class TaskMapper
{
    private final UserRepository repository;

    // DTO -> toEntity
    public Task toEntity(TaskRequestDTO requestDTO, User user)
    {
        return Task.builder()
                .title(requestDTO.getTitle())
                .description(requestDTO.getDescription())
                .user(user)
                .build();
    }

    // Entity -> toResponse
    public TaskResponseDTO toResponse(Task task)
    {
        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())

                .build();
    }
}

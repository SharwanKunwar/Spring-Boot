package com.unpredictableXRelations.UserAndTaskRelation.task.mapper;

import com.unpredictableXRelations.UserAndTaskRelation.task.dtos.TaskRequestDTO;
import com.unpredictableXRelations.UserAndTaskRelation.task.dtos.TaskResponseDTO;
import com.unpredictableXRelations.UserAndTaskRelation.task.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper
{
    // DTO -> toEntity
    public Task toEntity(TaskRequestDTO requestDTO)
    {
        return Task.builder()
                .title(requestDTO.getTitle())
                .description(requestDTO.getDescription())
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

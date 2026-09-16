package com.unpredictableXRelations.UserAndTaskRelation.task.service;

import com.unpredictableXRelations.UserAndTaskRelation.task.dtos.TaskRequestDTO;
import com.unpredictableXRelations.UserAndTaskRelation.task.dtos.TaskResponseDTO;

import java.util.List;
import java.util.UUID;

public interface TaskServiceHelper
{
    TaskResponseDTO create(TaskRequestDTO requestDTO, UUID id);
    List<TaskResponseDTO> getAllTask();
    TaskResponseDTO getTaskById(UUID id);
    List<TaskResponseDTO> getAllTaskByUserId(UUID id);
}

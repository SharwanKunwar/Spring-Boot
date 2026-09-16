package com.unpredictableXRelations.UserAndTaskRelation.task.service;

import com.unpredictableXRelations.UserAndTaskRelation.exceptions.ResourceNotFoundException;
import com.unpredictableXRelations.UserAndTaskRelation.task.dtos.TaskRequestDTO;
import com.unpredictableXRelations.UserAndTaskRelation.task.dtos.TaskResponseDTO;
import com.unpredictableXRelations.UserAndTaskRelation.task.entity.Task;
import com.unpredictableXRelations.UserAndTaskRelation.task.mapper.TaskMapper;
import com.unpredictableXRelations.UserAndTaskRelation.task.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskServiceIMP
{
    private final TaskRepository repository;
    private final TaskMapper mapper;


    // create task
    public TaskResponseDTO createTask(TaskRequestDTO requestDTO)
    {
        Task task = mapper.toEntity(requestDTO);
        Task savedTask = repository.save(task);
        return mapper.toResponse(savedTask);
    }

    // Get all tasks
    public List<TaskResponseDTO> getAllTask()
    {
        List<Task> tasks = repository.findAll();
        return tasks.stream().map(mapper::toResponse).toList();
    }

    //Get by id
    public TaskResponseDTO getTaskById(UUID id){
        Task task = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task Not Found"));
        return mapper.toResponse(task);
    }
}

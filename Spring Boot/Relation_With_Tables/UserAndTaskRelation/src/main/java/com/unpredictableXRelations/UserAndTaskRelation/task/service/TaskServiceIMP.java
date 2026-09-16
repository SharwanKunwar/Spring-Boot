package com.unpredictableXRelations.UserAndTaskRelation.task.service;

import com.unpredictableXRelations.UserAndTaskRelation.exceptions.ResourceNotFoundException;
import com.unpredictableXRelations.UserAndTaskRelation.task.dtos.TaskRequestDTO;
import com.unpredictableXRelations.UserAndTaskRelation.task.dtos.TaskResponseDTO;
import com.unpredictableXRelations.UserAndTaskRelation.task.entity.Task;
import com.unpredictableXRelations.UserAndTaskRelation.task.mapper.TaskMapper;
import com.unpredictableXRelations.UserAndTaskRelation.task.repository.TaskRepository;
import com.unpredictableXRelations.UserAndTaskRelation.user.entity.User;
import com.unpredictableXRelations.UserAndTaskRelation.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskServiceIMP implements TaskServiceHelper
{
    private final TaskRepository repository;
    private final UserRepository userRepository;
    private final TaskMapper mapper;


    // create task
    @Override
    public TaskResponseDTO create(TaskRequestDTO requestDTO, UUID id)
    {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        Task task = mapper.toEntity(requestDTO, user);
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

    @Override
    public List<TaskResponseDTO> getAllTaskByUserId(UUID id)
    {
        List<Task> tasks = repository.getAllTaskByUserId(id);
        return tasks.stream().map(mapper::toResponse).toList();
    }
}

package com.unpredictableXRelations.UserAndTaskRelation.task.controller;

import com.unpredictableXRelations.UserAndTaskRelation.task.dtos.TaskRequestDTO;
import com.unpredictableXRelations.UserAndTaskRelation.task.dtos.TaskResponseDTO;
import com.unpredictableXRelations.UserAndTaskRelation.task.service.TaskServiceHelper;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController
{
    private final TaskServiceHelper service;

    // create
    @PostMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> create(@RequestBody TaskRequestDTO requestDTO, @PathVariable UUID id)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO, id));
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTask()
    {
        return ResponseEntity.ok(service.getAllTask());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.getTaskById(id));
    }

    // Get task by user id
    @GetMapping("/user/{id}")
    public ResponseEntity<List<TaskResponseDTO>> getAllUserTask(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.getAllTaskByUserId(id));
    }
}

package com.unpredictableXsoft.Hard_delete.ProjectsXStore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler
{

    //Product not found exception
    @ExceptionHandler(ProjectNotFound.class)
    public ResponseEntity<Map<String, Object>> handleProjectNotFound(ProjectNotFound exception)
    {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("error", "Project not found.");
        response.put("message",exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // DTO validation error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationError(MethodArgumentNotValidException ex)
    {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        Map<String, Object> response = new HashMap<>();
        response.put("timeStamp", LocalDateTime.now());
        response.put("status",HttpStatus.BAD_REQUEST.value());
        response.put("error","Validation Failed");
        response.put("errors",errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
    }



}

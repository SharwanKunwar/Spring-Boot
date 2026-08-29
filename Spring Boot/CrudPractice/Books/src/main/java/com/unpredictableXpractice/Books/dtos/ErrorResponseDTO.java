package com.unpredictableXpractice.Books.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorResponseDTO
{
    private String message;
    private int status;
    private LocalDateTime timeStamp;
}

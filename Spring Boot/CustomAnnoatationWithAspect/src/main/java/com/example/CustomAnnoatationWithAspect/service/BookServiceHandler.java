package com.example.CustomAnnoatationWithAspect.service;

import com.example.CustomAnnoatationWithAspect.dtos.BookRequestDTO;
import com.example.CustomAnnoatationWithAspect.dtos.BookResponseDTO;

import java.util.List;

public interface BookServiceHandler
{
    BookResponseDTO createBook(BookRequestDTO bookRequestDTO);

}

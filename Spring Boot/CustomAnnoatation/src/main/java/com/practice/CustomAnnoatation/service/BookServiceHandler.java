package com.practice.CustomAnnoatation.service;

import com.practice.CustomAnnoatation.dtos.BookRequestDTO;
import com.practice.CustomAnnoatation.dtos.BookResponseDTO;

import java.util.List;

public interface BookServiceHandler
{
    BookResponseDTO createBook(BookRequestDTO bookRequestDTO);
}

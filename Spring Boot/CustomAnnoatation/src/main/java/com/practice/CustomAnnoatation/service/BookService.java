package com.practice.CustomAnnoatation.service;

import com.practice.CustomAnnoatation.annoatation.TrackResponseTime;
import com.practice.CustomAnnoatation.dtos.BookRequestDTO;
import com.practice.CustomAnnoatation.dtos.BookResponseDTO;
import com.practice.CustomAnnoatation.mapper.BookMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements BookServiceHandler
{
    private final BookMapper bookMapper;

    @TrackResponseTime
    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO)
    {
        BookResponseDTO response = bookMapper.toResponse(bookRequestDTO);
        return response;
    }



}

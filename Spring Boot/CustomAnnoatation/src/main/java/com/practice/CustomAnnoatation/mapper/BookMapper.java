package com.practice.CustomAnnoatation.mapper;

import com.practice.CustomAnnoatation.dtos.BookRequestDTO;
import com.practice.CustomAnnoatation.dtos.BookResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper
{
    public BookResponseDTO toResponse(BookRequestDTO bookRequestDTO){
        return BookResponseDTO.builder()
                .title(bookRequestDTO.getTitle())
                .description(bookRequestDTO.getDescription())
                .price(bookRequestDTO.getPrice())
                .build();
    }
}

package com.example.CustomAnnoatationWithAspect.service.implementation;

import com.example.CustomAnnoatationWithAspect.dtos.BookRequestDTO;
import com.example.CustomAnnoatationWithAspect.dtos.BookResponseDTO;
import com.example.CustomAnnoatationWithAspect.mapper.BookMapper;
import com.example.CustomAnnoatationWithAspect.service.BookServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class BookService implements BookServiceHandler
{
    private final BookMapper bookMapper;

    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO)
    {
        System.out.println("------------------- SERVICE LAYER STARTED-------------------");
        System.out.println("Title "+bookRequestDTO.getTitle());
        System.out.println("Author "+bookRequestDTO.getAuthor());
        System.out.println("Price "+bookRequestDTO.getPrice());
        System.out.println("--------------- Book created --------------");
        System.out.println("------------------- SERVICE LAYER END -------------------\n");
        BookResponseDTO response = bookMapper.toResponse(bookRequestDTO);
        return response;
    }

}

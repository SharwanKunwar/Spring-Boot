package com.unpredictableXfilters.FilterSeriesV01.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO
{
    private Long id;
    private String name;
    private int age;
    private String email;
}

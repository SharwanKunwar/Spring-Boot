package com.unpredictableXfilters.FilterSeriesV01.service;

import com.unpredictableXfilters.FilterSeriesV01.dtos.ProductRequestDTO;
import com.unpredictableXfilters.FilterSeriesV01.dtos.ProductResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceIMP implements ProductServiceHandler
{
    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO)
    {
        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(requestDTO.getId());
        response.setName(requestDTO.getName());
        response.setAge(requestDTO.getAge());
        response.setEmail(requestDTO.getEmail());

//        try {
//            Thread.sleep(100);
//        }catch (Exception ex){
//
//        }

        System.out.println("Product is Created.");

        return response;
    }
}

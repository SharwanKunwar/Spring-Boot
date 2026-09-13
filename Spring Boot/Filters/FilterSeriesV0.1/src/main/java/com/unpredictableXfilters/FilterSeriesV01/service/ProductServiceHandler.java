package com.unpredictableXfilters.FilterSeriesV01.service;

import com.unpredictableXfilters.FilterSeriesV01.dtos.ProductRequestDTO;
import com.unpredictableXfilters.FilterSeriesV01.dtos.ProductResponseDTO;

public interface ProductServiceHandler {
    ProductResponseDTO createProduct(ProductRequestDTO requestDTO);
}

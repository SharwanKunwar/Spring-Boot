package com.example.CrudWithJPA.service;

import com.example.CrudWithJPA.entity.Car;

import java.util.List;
import java.util.UUID;

public interface CarServiceHandler
{
    //W
    Car create(Car car);
    List<Car> saveAll(List<Car> cars);

    //R
    List<Car> getAllCars();

    //D
    void  deleteById(UUID id);


}

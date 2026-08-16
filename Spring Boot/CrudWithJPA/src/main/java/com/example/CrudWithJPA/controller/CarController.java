package com.example.CrudWithJPA.controller;

import com.example.CrudWithJPA.entity.Car;
import com.example.CrudWithJPA.service.CarServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
public class CarController
{
    private final CarServiceHandler carService;

    //Post request handler
    @PostMapping("/create")
    public Car createCar(@RequestBody Car car){
        return carService.create(car);
    }

    //Post request for saving in bulk
    @PostMapping("/bulk")
    public List<Car> createCars(@RequestBody List<Car> cars){
        return carService.saveAll(cars);
    }

    //Get request handler
    @GetMapping("/all")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    // Get by id request handler
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable UUID id)
    {
        return carService.getCarById(id);
    }

    //Delete request handler
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        carService.deleteById(id);
    }
}

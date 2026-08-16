package com.example.CrudWithJPA.service.Implementation;

import com.example.CrudWithJPA.entity.Car;
import com.example.CrudWithJPA.repository.CarRepository;
import com.example.CrudWithJPA.service.CarServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarService implements CarServiceHandler
{
    private final CarRepository carRepository;

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> saveAll(List<Car> cars) {
        return carRepository.saveAll(cars);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        carRepository.deleteById(id);
    }
}

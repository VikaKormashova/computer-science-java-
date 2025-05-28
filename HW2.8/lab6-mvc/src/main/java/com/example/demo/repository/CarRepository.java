package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarRepository {

    private final List<Car> cars = new ArrayList<>();

    public CarRepository() {
        // Заполняем список разными машинами с разными двигателями
        cars.add(new Car(1, "BMW", "X5", 2021, new PetrolEngine()));
        cars.add(new Car(2, "Audi", "A4", 2020, new DieselEngine()));
        cars.add(new Car(3, "Toyota", "Corolla", 2019, new Engine())); // generic engine
    }

    public List<Car> findAll() {
        return cars;
    }

    public Car findById(int id) {
        return cars.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
}
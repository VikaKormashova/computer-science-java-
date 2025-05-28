package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;
import com.example.demo.model.DieselEngine;
import com.example.demo.model.Engine;
import com.example.demo.model.PetrolEngine;

@Repository
public class CarRepository {

    private final List<Car> cars = new ArrayList<>();
    private int nextId = 4;

    public CarRepository() {
        // Изначально 3 машины для примера
        Car car1 = new Car();
        car1.setId(1);
        car1.setBrand("BMW");
        car1.setModel("X5");
        car1.setYear(2021);
        car1.setEngine(new Engine());

        Car car2 = new Car();
        car2.setId(2);
        car2.setBrand("Audi");
        car2.setModel("A4");
        car2.setYear(2022);
        car2.setEngine(new DieselEngine());

        Car car3 = new Car();
        car3.setId(3);
        car3.setBrand("Toyota");
        car3.setModel("Camry");
        car3.setYear(2023);
        car3.setEngine(new PetrolEngine());

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    public List<Car> findAll() {
        return cars;
    }

    public Car findById(int id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addCar(Car car) {
        car.setId(nextId++);
        cars.add(car);
    }
}
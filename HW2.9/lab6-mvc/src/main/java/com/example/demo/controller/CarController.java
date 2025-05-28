package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.model.DieselEngine;
import com.example.demo.model.Engine;
import com.example.demo.model.PetrolEngine;
import com.example.demo.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    // Показать список всех машин
    @GetMapping
    public String showAllCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "cars"; // новый шаблон cars.html
    }

    // Показать машину по id
    @GetMapping("/{id}")
    public String showCarById(@PathVariable int id, Model model) {
        Car car = carRepository.findById(id);
        if (car == null) {
            model.addAttribute("error", "Машина с id " + id + " не найдена");
            return "error";
        }
        model.addAttribute("car", car);
        return "car";  // твой существующий шаблон car.html
    }

    // Показать форму добавления новой машины
    @GetMapping("/add")
    public String showAddCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "add-car"; // шаблон add-car.html
    }

    // Обработать форму добавления машины
    @PostMapping("/add")
    public String addCarSubmit(@ModelAttribute Car car) {
        // Создаем двигатель по выбранному типу
        switch (car.getEngineType()) {
            case "Petrol" -> car.setEngine(new PetrolEngine());
            case "Diesel" -> car.setEngine(new DieselEngine());
            default -> car.setEngine(new Engine());
        }

        carRepository.addCar(car);

        return "redirect:/cars"; // редирект на список после добавления
    }
}
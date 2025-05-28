package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")  // Все методы контроллера будут по адресу /cars
public class CarController {

    @Autowired
    private CarRepository carRepository;

    // Показать список всех машин
    @GetMapping
    public String showAllCars(Model model) {
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "cars";  // возвращаем шаблон cars.html
    }

    // Показать машину по ID
    @GetMapping("/{id}")
    public String showCarById(@PathVariable int id, Model model) {
        Car car = carRepository.findById(id);
        if (car == null) {
            model.addAttribute("error", "Машина с id " + id + " не найдена");
            return "error"; // шаблон ошибки (создадим ниже)
        }
        model.addAttribute("car", car);
        return "car";  // используем уже твой car.html для отображения одной машины
    }
}
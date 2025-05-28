package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.model.Engine;
import com.example.demo.model.DieselEngine;
import com.example.demo.model.PetrolEngine;
import com.example.demo.repository.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Список всех машин
    @GetMapping
    public String listCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "list";
    }

    // Просмотр конкретной машины
    @GetMapping("/{id}")
    public String viewCar(@PathVariable int id, Model model) {
        Car car = carRepository.findById(id);
        if (car != null) {
            model.addAttribute("car", car);
            return "view";
        }
        return "redirect:/cars";
    }

    // Форма добавления
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("car", new Car());
        return "add-car";
    }

    // Добавление новой машины
    @PostMapping
    public String addCar(@RequestParam String brand,
                         @RequestParam String model,
                         @RequestParam int year,
                         @RequestParam String engineType) {

        Engine engine = switch (engineType.toLowerCase()) {
            case "diesel" -> new DieselEngine();
            default -> new PetrolEngine();
        };

        Car car = new Car(brand, model, year, engine);
        carRepository.addCar(car);
        return "redirect:/cars";
    }

    // Форма редактирования
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Car car = carRepository.findById(id);
        if (car != null) {
            model.addAttribute("car", car);
            return "edit";
        }
        return "redirect:/cars";
    }

    // Обновление машины (PATCH)
    @PatchMapping("/{id}")
    public String updateCar(@PathVariable int id,
                            @RequestParam String brand,
                            @RequestParam String model,
                            @RequestParam int year,
                            @RequestParam String engineType) {

        Car car = carRepository.findById(id);
        if (car != null) {
            Engine engine = switch (engineType.toLowerCase()) {
                case "diesel" -> new DieselEngine();
                default -> new PetrolEngine();
            };

            car.setBrand(brand);
            car.setModel(model);
            car.setYear(year);
            car.setEngine(engine);
        }
        return "redirect:/cars";
    }

    // Удаление машины (DELETE)
    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable int id) {
        carRepository.deleteById(id);
        return "redirect:/cars";
    }
}
package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;

    // Внедряем репозиторий через конструктор
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Отобразить список всех машин
    @GetMapping
    public String listCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "list"; // имя шаблона для списка машин
    }

    // Отобразить детали одной машины по id
    @GetMapping("/{id}")
    public String viewCar(@PathVariable int id, Model model) {
        Car car = carRepository.findById(id);
        if (car != null) {
            model.addAttribute("car", car);
            return "view"; // имя шаблона с деталями машины
        }
        return "redirect:/cars"; // если не найден, вернуть на список
    }

    // Форма добавления новой машины
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("car", new Car());
        return "add-car"; // имя шаблона формы добавления
    }

    // Обработка отправки формы добавления
    @PostMapping
    public String addCar(@ModelAttribute Car car) {
        carRepository.addCar(car);
        return "redirect:/cars"; // после добавления перенаправляем на список
    }

    // Форма редактирования существующей машины
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Car car = carRepository.findById(id);
        if (car != null) {
            model.addAttribute("car", car);
            return "edit"; // имя шаблона формы редактирования
        }
        return "redirect:/cars";
    }

    // Обработка обновления машины (PATCH)
    @PatchMapping("/{id}")
    public String updateCar(@PathVariable int id, @ModelAttribute Car updatedCar) {
        Car car = carRepository.findById(id);
        if (car != null) {
            car.setBrand(updatedCar.getBrand());
            car.setModel(updatedCar.getModel());
            car.setYear(updatedCar.getYear());
            car.setEngine(updatedCar.getEngine());
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
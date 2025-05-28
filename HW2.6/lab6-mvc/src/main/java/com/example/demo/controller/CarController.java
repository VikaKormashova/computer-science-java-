package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Car;

@Controller
public class CarController {

    @Autowired
    private Car car;

    @GetMapping("/car")
    public String showCar(Model model) {
        model.addAttribute("car", car);
        return "car";  // Имя шаблона: car.html
    }
}

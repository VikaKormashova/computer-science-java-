package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calc")
    public String calculate(
            @RequestParam(name = "a", required = false, defaultValue = "0") double a,
            @RequestParam(name = "b", required = false, defaultValue = "0") double b,
            @RequestParam(name = "op", required = false, defaultValue = "+") String op,
            Model model) {

        double result = 0;
        String error = null;

        switch (op) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> {
                if (b == 0) {
                    error = "Ошибка: деление на ноль";
                } else {
                    result = a / b;
                }
            }
            default -> {
                if (error == null) {
                    error = "Ошибка: неизвестная операция";
                }
            }
        }

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("op", op);
        model.addAttribute("result", result);
        model.addAttribute("error", error);

        return "calc";
    }
}
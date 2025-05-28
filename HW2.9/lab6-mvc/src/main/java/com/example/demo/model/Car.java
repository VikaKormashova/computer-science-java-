package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Car {

    private int id;
    private String brand;
    private String model;
    private int year;
    private Engine engine;

    // Для формы — тип двигателя (Generic, Petrol, Diesel)
    private String engineType = "Generic";

    public Car() {
        // Пустой конструктор нужен для биндинга формы
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public Engine getEngine() { return engine; }
    public void setEngine(Engine engine) { this.engine = engine; }

    public String getEngineType() { return engineType; }
    public void setEngineType(String engineType) { this.engineType = engineType; }
}
package com.example.demo.model;

public class Car {
    private int id;
    private String brand;
    private String model;
    private int year;
    private Engine engine;

    public Car(int id, String brand, String model, int year, Engine engine) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Engine getEngine() {
        return engine;
    }
}
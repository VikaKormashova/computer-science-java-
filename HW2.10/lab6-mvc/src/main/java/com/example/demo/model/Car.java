package com.example.demo.model;

public class Car {

    private static int counter = 0;  // счётчик для генерации id

    private int id;
    private String brand;
    private String model;
    private int year;
    private Engine engine;

    public Car() {
        this.id = ++counter;
        this.brand = "";
        this.model = "";
        this.year = 0;
        this.engine = new Engine();
    }

    public Car(String brand, String model, int year, Engine engine) {
        this.id = ++counter;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    // Геттеры и сеттеры для всех полей

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public void setId(int id) {
        this.id = id;
    }
}
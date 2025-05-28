package com.example.beans;

public class Car {
    private String brand;
    private int year;

    // 👇 Добавляем конструктор
    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
        System.out.println("Car constructor with args: " + brand + ", " + year);
    }

    public void init() {
        System.out.println("Init method called for: " + brand);
    }

    public void destroy() {
        System.out.println("Destroy method called for: " + brand);
    }

    public void printInfo() {
        System.out.println("Car: " + brand + ", Year: " + year);
    }
}

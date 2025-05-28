package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    private double volume;

    public Engine() {
        this.volume = 1.6;
    }

    public Engine(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    public String getType() {
        return "Generic";
    }
}
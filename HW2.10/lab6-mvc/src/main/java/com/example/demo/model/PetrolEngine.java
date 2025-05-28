package com.example.demo.model;

public class PetrolEngine extends Engine {

    public PetrolEngine() {
        super(1.8);
    }

    @Override
    public String getType() {
        return "Petrol";
    }
}
package com.example.demo.model;

public class DieselEngine extends Engine {

    public DieselEngine () {
        super(2.5);
    }

    @Override
    public String getType() {
        return "Diesel";
    }
}
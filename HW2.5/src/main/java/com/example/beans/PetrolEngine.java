package com.example.beans;

import org.springframework.stereotype.Component;

@Component("petrolEngine")
public class PetrolEngine extends Engine {
    @Override
    public String getType() {
        return "Petrol Engine";
    }
}

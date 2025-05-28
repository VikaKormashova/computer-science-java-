package com.example.beans;

import org.springframework.stereotype.Component;

@Component("dieselEngine")
public class DieselEngine extends Engine {
    @Override
    public String getType() {
        return "Diesel Engine";
    }
}

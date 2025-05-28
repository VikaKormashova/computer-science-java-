package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Car {

    private final Engine engine;

    @Autowired
    public Car(@Qualifier("dieselEngine") Engine engine) {
        this.engine = engine;
    }

    public void printInfo() {
        System.out.println("Car with engine: " + engine.getType());
    }

    @PostConstruct
    public void init() {
        System.out.println("Car init()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Car destroy()");
    }
}

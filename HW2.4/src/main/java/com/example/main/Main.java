package com.example.main;

import com.example.beans.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Car car = context.getBean("carBean", Car.class);
        car.printInfo();

        context.close();
    }
}

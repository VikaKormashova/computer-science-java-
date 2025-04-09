package com.exampl;

import com.example.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Загрузка контекста Spring
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Получение бина
        Person person = (Person) context.getBean("personBean");

        // Вывод информации
        System.out.println(person);
    }
}

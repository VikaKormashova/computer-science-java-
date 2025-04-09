package com.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.view.Viewer;

public class MainApp {
    public static void main(String[] args) {
        // Загружаем Spring-контекст
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Получаем бин Viewer
        Viewer<?> viewer = (Viewer<?>) context.getBean("viewer");

        // Выводим информацию
        viewer.showCategory();
    }
}
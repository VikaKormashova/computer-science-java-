package com.example.view;

import com.example.model.Category;

public class Viewer<T extends Category> {
    private T category;

    public Viewer(T category) {
        this.category = category;
    }

    public void showCategory() {
        System.out.println("Отображаем категорию: " + category.getCategoryName());
    }
}
package com.example.company;

public interface Worker {
	default void work() {
        System.out.println("Worker is doing some work");
    }

}

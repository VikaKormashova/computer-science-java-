package com.example.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private Date birthDate;

    public Person(String firstName, String lastName, SimpleDateFormat dateFormat) throws ParseException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = dateFormat.parse("2000-01-01");  
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
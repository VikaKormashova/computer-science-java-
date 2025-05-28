package com.example.company;

public class Employee extends Person {
    private String position;
    private double payment;
    private int experience;
    private String department;

    public Employee(String name, String surname, String gender, boolean active,
                    String position, double payment, int experience, String department) {
        super(name, surname, gender, active);
        this.position = position;
        this.payment = payment;
        this.experience = experience;
        this.department = department;
    }
    public Employee(){
        this("","", "",false,"",0,0,"");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
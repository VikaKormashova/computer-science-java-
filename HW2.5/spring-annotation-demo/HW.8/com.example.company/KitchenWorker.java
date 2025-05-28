package com.example.company;

public class KitchenWorker extends Employee implements Worker {
    private String specialty;
    private int yearsOfExperience;

    public KitchenWorker(String name, String surname, String gender, boolean active,
                         String position, double payment, int experience, String department,
                         String specialty, int yearsOfExperience) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.specialty = specialty;
        this.yearsOfExperience = yearsOfExperience;
    }
    public KitchenWorker(){
        this("","", "",false,"",0,0,"","", 0);
    }
    @Override
    public void work() {
        System.out.println(getName() + " is cooking.");
    }

     public void cookDish(String dish) {
        System.out.println(getName() + " is cooking " + dish);
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
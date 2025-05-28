package com.example.company;

public class GuardWorker extends Employee implements Worker {
    private String guardEquipment;
    private int patrolArea;

    public GuardWorker(String name, String surname, String gender, boolean active,
                       String position, double payment, int experience, String department,
                       String guardEquipment, int patrolArea) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.guardEquipment = guardEquipment;
        this.patrolArea = patrolArea;
    }

    public GuardWorker(){
        this("","", "",false,"",0,0,"","", 0);
    }
    @Override
    public void work() {
        System.out.println(getName() + " is guarding the territory.");
    }

    public void checkPerimeter() {
        System.out.println(getName() + " is checking the perimeter.");
    }
    public String getGuardEquipment() {
        return guardEquipment;
    }

    public void setGuardEquipment(String guardEquipment) {
        this.guardEquipment = guardEquipment;
    }

    public int getPatrolArea() {
        return patrolArea;
    }

    public void setPatrolArea(int patrolArea) {
        this.patrolArea = patrolArea;
    }
}
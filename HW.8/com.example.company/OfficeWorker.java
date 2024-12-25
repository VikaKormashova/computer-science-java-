package com.example.company;

public class OfficeWorker extends Employee implements Worker {
    private String area;
    private int numberOfTasks;

    public OfficeWorker(String name, String surname, String gender, boolean active,
                       String position, double payment, int experience, String department,
                       String area, int numberOfTasks) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.area = area;
        this.numberOfTasks = numberOfTasks;
    }

    public OfficeWorker(){
        this("","", "",false,"",0,0,"","", 0);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is processing documents.");
    }

      public void organizeMeeting(String topic) {
        System.out.println(getName() + " is organizing meeting about " + topic);
    }
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public void setNumberOfTasks(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }
}
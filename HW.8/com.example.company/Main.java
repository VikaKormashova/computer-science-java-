package com.example.company;

public class Main {
    public static void main(String[] args) {
        KitchenWorker chef = new KitchenWorker("Gordon", "Ramsay", "male", true,
                "Chef", 5000, 20, "Kitchen", "Italian", 15);
        OfficeWorker clerk = new OfficeWorker("Pam", "Beasley", "female", true,
                "Sales Representative", 2000, 3, "Sales", "North", 10);
        GuardWorker security = new GuardWorker("Frank", "Castle", "male", true,
                "Security Guard", 1500, 5, "Security", "Taser", 2);

       chef.work();
        chef.cookDish("Pasta");
       clerk.work();
        clerk.organizeMeeting("Sales");
        security.work();
        security.checkPerimeter();

    }
}
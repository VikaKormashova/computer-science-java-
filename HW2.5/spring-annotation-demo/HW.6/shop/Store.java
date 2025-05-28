package shop; 

import java.util.ArrayList;

public class Store {
    private int numberOfCashRegisters;
    private Product[] products; // Массив продуктов
    private int numberOfSellers;

    public Store(int numberOfCashRegisters, int numberOfSellers, Product[] products) {
        this.numberOfCashRegisters = numberOfCashRegisters;
        this.numberOfSellers = numberOfSellers;
        this.products = products;
    }

    public Store() {
        this(0, 0, new Product[0]); // Дефолтный конструктор
    }

    public void addProduct(Product product) {
        // Логика добавления продуктов будет реализована в дальнейшем
    }

    public double calculateEfficiency() {
        double averageWeight = calculateAverageWeight();
        double cashRegisterEfficiency = (double) numberOfSellers / numberOfCashRegisters;
        return (averageWeight * cashRegisterEfficiency);
    }

    private double calculateAverageWeight() {
        double totalWeight = 0;
        for (Product product : products) {
            totalWeight += product.getWeight();
        }
        return totalWeight / products.length; // Средний вес
    }

    public String toString() {
        return "Store{" +
                "numberOfCashRegisters=" + numberOfCashRegisters +
                ", numberOfSellers=" + numberOfSellers +
                '}';
    }

    // Геттеры
    public int getNumberOfCashRegisters() {
        return numberOfCashRegisters;
    }

    public int getNumberOfSellers() {
        return numberOfSellers;
    }

    public static class Product {
        private double weight; // Вес
        private double price; // Цена

        public Product(double weight, double price) {
            this.weight = weight;
            this.price = price;
        }

        public Product() {
            this(0, 0); // Дефолтный конструктор
        }

        // Геттеры и мутаторы
        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}

package shop;

public class Supermarket extends Store {
    private double area; // Площадь магазина
    private String[] productCategories; // Массив категорий товаров

    public Supermarket(int numberOfCashRegisters, int numberOfSellers, Product[] products, double area, String[] productCategories) {
        super(numberOfCashRegisters, numberOfSellers, products);
        this.area = area;
        this.productCategories = productCategories;
    }

    public Supermarket() {
        this(0, 0, new Product[0], 0, new String[0]); // Дефолтный конструктор
    }

    public double calculateEfficiency() {
        double cashRegisterEfficiency = (double) getNumberOfSellers() / getNumberOfCashRegisters();
        return (area / productCategories.length) * cashRegisterEfficiency;
    }

    @Override
    public String toString() {
        return "Supermarket{" +
                "area=" + area +
                ", numberOfCashRegisters=" + getNumberOfCashRegisters() +
                ", numberOfSellers=" + getNumberOfSellers() +
                ", productCategories=" + productCategories.length +
                '}';
    }

    // Мутаторы для площади и категорий
    public void setArea(double area) {
        this.area = area;
    }

    public void setProductCategories(String[] productCategories) {
        this.productCategories = productCategories;
    }
}



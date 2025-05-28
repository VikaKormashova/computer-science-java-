package shop; 

public class Main {
    public static void main(String[] args) {
        // Пример создания продуктов
        Store.Product apple = new Store.Product(0.2, 1.0); // Вес: 0.2 кг, Цена: 1.0
        Store.Product bread = new Store.Product(0.5, 0.8); // Вес: 0.5 кг, Цена: 0.8
        Store.Product milk = new Store.Product(1.0, 1.5); 
        Store.Product cheese = new Store.Product(0.3, 2.0); 
        Store.Product banana = new Store.Product(0.15, 0.5); 
        Store.Product yogurt = new Store.Product(0.25, 0.9); 

        // Создание массива продуктов с добавленными товарами
        Store.Product[] products = {apple, bread, milk, cheese, banana, yogurt};

        // Создание магазина
        Store myStore = new Store(3, 5, products);
        System.out.println(myStore);
        System.out.println("Efficiency: " + myStore.calculateEfficiency());

        // Создание супермаркета
        Supermarket mySupermarket = new Supermarket(5, 10, products, 200.0, new String[]{"Fruits", "Dairy", "Bakery"});
        System.out.println(mySupermarket);
        System.out.println("Supermarket Efficiency: " + mySupermarket.calculateEfficiency());
    }
}

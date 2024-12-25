package store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 1. Генерация случайных продуктов
        List<Product> products = generateRandomProducts(20);
        System.out.println("Initial list of products:");
        products.forEach(System.out::println);
        System.out.println();

        // 2. Создание корзины и добавление продуктов (с проверкой дубликатов)
        List<Product> cart = new ArrayList<>();
        addProductsToCart(cart, products.subList(0, 10)); // Добавление первых 10 продуктов
        System.out.println("Products in the cart:");
        cart.forEach(System.out::println);
        System.out.println();

        // 3. Удаление продуктов с весом > 5 кг или стоимостью > 10000
        removeExpensiveOrHeavyProducts(cart);
        System.out.println("Products in the cart after removing expensive/heavy products:");
        cart.forEach(System.out::println);
        System.out.println();

        // 4. Перемещение любимого продукта в начало списка
        String favoriteProductName = ProductName.MILK.toString(); // Выберем MILK как любимый продукт
        moveFavoriteProductToFirst(cart, favoriteProductName);
        System.out.println("Products in the cart with favorite product at the start:");
        cart.forEach(System.out::println);
        System.out.println();

        // 5. Вывод продуктов стоимостью < 10 и весом > 2
        System.out.println("Products with price < 10 and weight > 2:");
        filterAndPrintProducts(products);
    }

    private static List<Product> generateRandomProducts(int count) {
        List<Product> products = new ArrayList<>();
        Random random = new Random();
        ProductName[] names = ProductName.values();

        for (int i = 0; i < count; i++) {
            String name = names[random.nextInt(names.length)].toString();
            double price;
            double weight;

            // Гарантируем, что некоторые продукты удовлетворяют условию
            if (i % 3 == 0) {  // Каждые три продукта будут с нужными параметрами
                price = random.nextDouble() * 8 + 1; // Цена от 1 до 9
                weight = random.nextDouble() * 5 + 2.1; // Вес от 2.1 до 7.1
            } else {
                price = random.nextDouble() * 15000;
                weight = random.nextDouble() * 10;
            }


            products.add(new Product(name, price, weight));
        }
        return products;
    }
    private static void addProductsToCart(List<Product> cart, List<Product> productsToAdd) {
        for (Product product : productsToAdd) {
            if (!cart.contains(product)) {
                cart.add(product);
            }
        }
    }

    private static void removeExpensiveOrHeavyProducts(List<Product> cart) {
        cart.removeIf(product -> product.getWeight() > 5 || product.getPrice() > 10000);
    }

    private static void moveFavoriteProductToFirst(List<Product> cart, String favoriteProductName) {
        Product favoriteProduct = null;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getName().equals(favoriteProductName)) {
                favoriteProduct = cart.remove(i);
                break;
            }
        }
        if (favoriteProduct != null) {
            cart.add(0, favoriteProduct); // Добавить в начало
        }
    }

  private static void filterAndPrintProducts(List<Product> products) {
        products.stream()
          .filter(product -> product.getPrice() < 10 && product.getWeight() > 2)
          .forEach(System.out::println);
      }
}
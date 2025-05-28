package l5;

import java.util.Scanner;

public class Laba1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты трех точек (x y z для каждой):");

        double x1, y1, z1, x2, y2, z2, x3, y3, z3;

        try {
            x1 = scanner.nextDouble();
            y1 = scanner.nextDouble();
            z1 = scanner.nextDouble();
            x2 = scanner.nextDouble();
            y2 = scanner.nextDouble();
            z2 = scanner.nextDouble();
            x3 = scanner.nextDouble();
            y3 = scanner.nextDouble();
            z3 = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Ошибка ввода данных!");
            scanner.close();
            return;
        }

        Point3d p1 = new Point3d(x1, y1, z1);
        Point3d p2 = new Point3d(x2, y2, z2);
        Point3d p3 = new Point3d(x3, y3, z3);

        if (p1.equals(p2) || p1.equals(p3) || p2.equals(p3)) {
            System.out.println("Две или более точек совпадают. Невозможно вычислить площадь.");
        } else {
            double area = computeArea(p1, p2, p3);
            System.out.println("Площадь треугольника: " + area);
        }

        scanner.close();
    }

    public static double computeArea(Point3d p1, Point3d p2, Point3d p3) {
        double a = p1.distanceTo(p2);
        double b = p2.distanceTo(p3);
        double c = p3.distanceTo(p1);

        if (a + b <= c || a + c <= b || b + c <= a) {
            return 0; // Вырожденный треугольник
        }

        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return Math.round(area * 100.0) / 100.0; // Округление до 2 знаков
    }
}
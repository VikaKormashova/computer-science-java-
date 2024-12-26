package studentstats;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static TreeSet<Student> studentsByScholarship = new TreeSet<>(new StudentComparator.ScholarshipComparator());
    private static TreeSet<Student> studentsByAverageGrade = new TreeSet<>(new StudentComparator.AverageGradeComparator());
    private static TreeSet<Student> studentsByAge = new TreeSet<>(new StudentComparator.AgeComparator());
    private static List<Student> students = new ArrayList<>();

    private static int getMenuChoice(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 7) {
                    return choice;
                } else {
                    System.out.println("Неверный выбор. Пожалуйста, введите число от 1 до 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
            }
        }
    }

    private static int getIntegerInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
            }
        }
    }
    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите число.");
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }


    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getMenuChoice("Выберите пункт меню: ");
            try {
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 3:
                        changeGrade();
                        break;
                    case 4:
                        changeScholarship();
                        break;
                    case 5:
                        updateAttendance();
                        break;
                    case 6:
                        showSortedList();
                        break;
                    case 7:
                        running = false;
                        break;
                    default:
                        System.out.println("Неверный выбор.");
                }
            } catch (Exception e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента");
        System.out.println("3. Изменить оценку студента");
        System.out.println("4. Изменить стипендию студента");
        System.out.println("5. Добавить отметку о посещении/непосещении");
        System.out.println("6. Отобразить отсортированный список студентов");
        System.out.println("7. Выход");
    }
    // ... (методы addStudent, removeStudent, changeGrade, changeScholarship, updateAttendance, showSortedList) ...
    private static void addStudent() throws InvalidStudentException {
        int age = getIntegerInput("Введите возраст студента: ");
        double averageGrade = getDoubleInput("Введите среднюю оценку студента: ");
        String firstName = getStringInput("Введите имя студента: ");
        String lastName = getStringInput("Введите фамилию студента: ");
        String middleName = getStringInput("Введите отчество студента: ");
        double scholarship = getDoubleInput("Введите размер стипендии студента: ");
        String gender = getStringInput("Введите пол студента (м/ж): ");

        Student student = new Student(firstName, lastName, middleName, age, gender, averageGrade, scholarship);
        students.add(student);
        studentsByAge.add(student);
        studentsByAverageGrade.add(student);
        studentsByScholarship.add(student);

        System.out.println("Студент " + firstName + " " + lastName + " успешно добавлен!");
    }
    private static void removeStudent() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст. Нечего удалять.");
            return;
        }

        System.out.println("Список студентов:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getLastName() + " " + students.get(i).getFirstName());
        }

        int studentIndex = getIntegerInput("Введите номер студента для удаления: ") - 1;

        if (studentIndex >= 0 && studentIndex < students.size()) {
            Student studentToRemove = students.get(studentIndex);
            students.remove(studentIndex);
            studentsByAge.remove(studentToRemove);
            studentsByAverageGrade.remove(studentToRemove);
            studentsByScholarship.remove(studentToRemove);
            System.out.println("Студент " + studentToRemove.getFirstName() + " " + studentToRemove.getLastName() + " успешно удален.");
        } else {
            System.out.println("Неверный номер студента.");
        }
    }

    private static void changeGrade() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст. Нечего изменять.");
            return;
        }

        System.out.println("Список студентов:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getLastName() + " " + students.get(i).getFirstName());
        }

        int studentIndex = getIntegerInput("Введите номер студента для изменения оценки: ") - 1;

        if (studentIndex >= 0 && studentIndex < students.size()) {
            double newGrade = getDoubleInput("Введите новую среднюю оценку студента: ");
            Student studentToUpdate = students.get(studentIndex);
            studentsByAverageGrade.remove(studentToUpdate);
            studentToUpdate.setAverageGrade(newGrade);
            studentsByAverageGrade.add(studentToUpdate);
            System.out.println("Оценка студента " + studentToUpdate.getFirstName() + " " + studentToUpdate.getLastName() + " успешно изменена.");
        } else {
            System.out.println("Неверный номер студента.");
        }
    }
    private static void changeScholarship() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст. Нечего изменять.");
            return;
        }

        System.out.println("Список студентов:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getLastName() + " " + students.get(i).getFirstName());
        }

        int studentIndex = getIntegerInput("Введите номер студента для изменения стипендии: ") - 1;

        if (studentIndex >= 0 && studentIndex < students.size()) {
            double newScholarship = getDoubleInput("Введите новый размер стипендии студента: ");
            Student studentToUpdate = students.get(studentIndex);
            studentsByScholarship.remove(studentToUpdate);
            studentToUpdate.setScholarship(newScholarship);
            studentsByScholarship.add(studentToUpdate);

            System.out.println("Стипендия студента " + studentToUpdate.getFirstName() + " " + studentToUpdate.getLastName() + " успешно изменена.");
        } else {
            System.out.println("Неверный номер студента.");
        }
    }
    private static void updateAttendance() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст. Нечего отмечать.");
            return;
        }

        System.out.println("Список студентов:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getLastName() + " " + students.get(i).getFirstName());
        }

        int studentIndex = getIntegerInput("Введите номер студента для отметки посещения: ") - 1;

        if (studentIndex >= 0 && studentIndex < students.size()) {
           String attendance = getStringInput("Введите отметку о посещении (был/не был): ");
            Student studentToUpdate = students.get(studentIndex);
            studentToUpdate.setAttendance(attendance);
            System.out.println("Отметка о посещении студента " + studentToUpdate.getFirstName() + " " + studentToUpdate.getLastName() + " успешно обновлена.");
        } else {
            System.out.println("Неверный номер студента.");
        }
    }
    private static void showSortedList() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }

        System.out.println("Выберите вариант сортировки:");
        System.out.println("1. По возрасту");
        System.out.println("2. По среднему баллу");
        System.out.println("3. По размеру стипендии");

        int sortChoice = getIntegerInput("Выберите пункт меню: ");

        switch (sortChoice) {
            case 1:
                System.out.println("Список студентов, отсортированный по возрасту:");
                studentsByAge.forEach(System.out::println);
                break;
            case 2:
                System.out.println("Список студентов, отсортированный по среднему баллу:");
                studentsByAverageGrade.forEach(System.out::println);
                break;
            case 3:
                System.out.println("Список студентов, отсортированный по размеру стипендии:");
                studentsByScholarship.forEach(System.out::println);
                break;
            default:
                System.out.println("Неверный вариант сортировки.");
        }
    }
}
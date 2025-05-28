package manager;


public class Main {
    public static void main(String[] args) {
        Group group = new Group();

        try {
            // Добавление студентов через консоль
            group.addStudent();
            group.addStudent();

            // Добавление студента через объект
            Student student3 = new Student(22, "Мужской", "Иван", "Иванов", "Иванович", 3, 4.6);
            group.addStudent(student3);

            System.out.println("Группа после добавления: " + group);
            System.out.println("Количество студентов в группе: " + group.getStudentCount());


            // Получение студента по индексу
            System.out.println("Студент по индексу 1: " + group.getStudent(1));


            // Удаление студента
            group.removeStudent(1);
            System.out.println("Группа после удаления студента с индексом 1: " + group);

            System.out.println("Количество студентов в группе: " + group.getStudentCount());


            // Попытка удаления когда студентов < 3
           // group.removeStudent(0);
          //  group.removeStudent(0); // Это вызовет ошибку, так как останется 1 студент

        } catch (NotCorrectAgeException e) {
            System.out.println("Ошибка при создании студента: " + e.getMessage());
        } catch (GroupOverflowException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (GroupMinStudentsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
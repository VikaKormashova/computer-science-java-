package manager; // Замените на имя вашего пакета

import java.util.Arrays;
import java.util.Scanner;

public class Group {
    private Student[] students;
    private int studentCount;
    private static final int MAX_STUDENTS = 15;
    private static final int MIN_STUDENTS = 3;
    private static Scanner scanner = new Scanner(System.in);

    public Group() {
        this.students = new Student[MAX_STUDENTS];
        this.studentCount = 0;
    }

    //Перегрузка метода добавления с параметром объекта класса Студент
    public void addStudent(Student student) throws GroupOverflowException {
        if (studentCount >= MAX_STUDENTS) {
            throw new GroupOverflowException("Группа переполнена, нельзя добавить больше студентов");
        }
        students[studentCount] = student;
        studentCount++;
    }


    //Перегрузка метода добавления без параметра (заполнение через консоль)
    public void addStudent() throws GroupOverflowException {
        if (studentCount >= MAX_STUDENTS) {
            throw new GroupOverflowException("Группа переполнена, нельзя добавить больше студентов");
        }

        Student newStudent = createStudentFromConsole();
        students[studentCount] = newStudent;
        studentCount++;
    }

    private Student createStudentFromConsole() {
        String firstName;
        String lastName;
        String middleName;
        String gender;
        int age;
        int course;
        double averageGrade;

        System.out.println("Введите имя студента: ");
        firstName = scanner.nextLine();

        System.out.println("Введите фамилию студента: ");
        lastName = scanner.nextLine();

        System.out.println("Введите отчество студента: ");
        middleName = scanner.nextLine();


        System.out.println("Введите пол студента: ");
        gender = scanner.nextLine();

        while (true) {
            try {
                System.out.println("Введите возраст студента: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age < 16 || age > 60)
                    throw new NotCorrectAgeException("Возраст должен быть от 16 до 60");
                break; // Если ввод корректен выходим из цикла
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат возраста. Введите целое число.");
            } catch (NotCorrectAgeException e) {
                System.out.println(e.getMessage());
            }
        }


        while (true) {
            try {
                System.out.println("Введите курс студента: ");
                course = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат курса. Введите целое число.");
            }
        }

        while (true) {
            try {
                System.out.println("Введите средний балл студента: ");
                averageGrade = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат среднего балла. Введите число.");
            }
        }

        try {
            return new Student(age, gender, firstName, lastName, middleName, course, averageGrade);
        } catch (NotCorrectAgeException e) {
            System.out.println(e.getMessage());
            return null; // Если возраст некорректный, не добавляем студента
        }
    }


    public void removeStudent(int index) throws GroupMinStudentsException {
        if (studentCount <= MIN_STUDENTS) {
            throw new GroupMinStudentsException("В группе не может быть меньше " + MIN_STUDENTS + " студентов");
        }
        if (index < 0 || index >= studentCount) {
            throw new IndexOutOfBoundsException("Недопустимый индекс студента");
        }
        System.arraycopy(students, index + 1, students, index, studentCount - index - 1);
        students[studentCount - 1] = null;
        studentCount--;
    }


    public Student getStudent(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= studentCount) {
            throw new IndexOutOfBoundsException("Недопустимый индекс студента");
        }
        return students[index];
    }


    public int getStudentCount() {
        return studentCount;
    }

    @Override
    public String toString() {
        return "Group{" +
                "students=" + Arrays.toString(Arrays.copyOf(students, studentCount)) +
                ", studentCount=" + studentCount +
                '}';
    }
}


class GroupOverflowException extends Exception {
    public GroupOverflowException(String message) {
        super(message);
    }
}

class GroupMinStudentsException extends Exception {
    public GroupMinStudentsException(String message) {
        super(message);
    }
}
            
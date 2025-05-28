package studentstats;

import java.util.Comparator;

public class StudentComparator {

    public static class AverageGradeComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.getAverageGrade(), s1.getAverageGrade()); // Обратная сортировка
        }
    }

    public static class ScholarshipComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.getScholarship(), s1.getScholarship()); // Обратная сортировка
        }
    }

    public static class AgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s2.getAge() - s1.getAge(); // Обратная сортировка
        }
    }

    public static class AttendanceComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.getAttendancePercentage(), s1.getAttendancePercentage()); // Обратная сортировка
        }
    }
}
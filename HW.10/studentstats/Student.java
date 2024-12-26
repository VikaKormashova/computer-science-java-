package studentstats;

public class Student {
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    private String gender;
    private double averageGrade;
    private double scholarship;
    private int attendedClasses;
    private int missedClasses;
    private String attendance;

    public Student(String firstName, String lastName, String middleName, int age, String gender, double averageGrade, double scholarship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.gender = gender;
        this.averageGrade = averageGrade;
        this.scholarship = scholarship;
        this.attendedClasses = 0;
        this.missedClasses = 0;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void setAttendedClasses(int attendedClasses) {
        this.attendedClasses = attendedClasses;
    }

    public int getMissedClasses() {
        return missedClasses;
    }

    public void setMissedClasses(int missedClasses) {
        this.missedClasses = missedClasses;
    }
    public double getAttendancePercentage() {
        if (attendedClasses + missedClasses == 0) {
            return 0.0; // Предотвращает деление на ноль
        }
        return (double) attendedClasses / (attendedClasses + missedClasses) * 100;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
       this.averageGrade = averageGrade;
    }

    public double getScholarship() {
        return scholarship;
    }

    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }
    
    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + ", возраст: " + age + ", пол: " + gender + ", средний балл: " + averageGrade + ", стипендия: " + scholarship + ", посещаемость " + attendance;
    }
}
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    String id;
    double grade1, grade2, grade3;
    double average;
    String remark;

    public Student(String name, String id, double grade1, double grade2, double grade3) {
        this.name = name;
        this.id = id;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        computeAverage();
        computeRemark();
    }

    private void computeAverage() {
        average = (grade1 + grade2 + grade3) / 3;
    }

    private void computeRemark() {
        if (average >= 90)
            remark = "Excellent";
        else if (average >= 80)
            remark = "Very Good";
        else if (average >= 70)
            remark = "Good";
        else if (average >= 60)
            remark = "Needs Improvement";
        else
            remark = "Fail";
    }
}

public class StudentGrade {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            displayMenu();
            choice = getIntInput("Enter choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 3);
    }

    // Display Menu
    public static void displayMenu() {
        System.out.println("\nSTUDENT GRADE MANAGEMENT SYSTEM");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Exit");
    }

    // Add Student
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        double g1 = getGradeInput("Enter Grade for Subject 1: ");
        double g2 = getGradeInput("Enter Grade for Subject 2: ");
        double g3 = getGradeInput("Enter Grade for Subject 3: ");

        Student student = new Student(name, id, g1, g2, g3);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    // View All Students
    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students recorded.");
            return;
        }

        System.out.println("-----------------------------------------------------");
        System.out.printf("%-10s %-18s %-10s %-15s\n", "ID", "Name", "Average", "Remark");
        System.out.println("-----------------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-10s %-18s %-10.2f %-15s\n",
                    s.id, s.name, s.average, s.remark);
        }

        System.out.println("-----------------------------------------------------");
    }

    // Grade Input Validation
    public static double getGradeInput(String message) {
        double grade;

        while (true) {
            System.out.print(message);
            grade = sc.nextDouble();

            if (grade >= 0 && grade <= 100) {
                sc.nextLine(); // clear buffer
                return grade;
            } else {
                System.out.println("Invalid grade! Must be between 0 and 100.");
            }
        }
    }

    // Integer Input Validation
    public static int getIntInput(String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            sc.next();
            System.out.print(message);
        }
        int value = sc.nextInt();
        sc.nextLine(); // clear buffer
        return value;
    }
}

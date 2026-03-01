package simpleooptask;

class Student {

    // Attributes
    String name;
    int age;
    String course;

    // Method to display student information
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println();
    }
}

// Step 2: Create Objects in main method
public class SimpleOOpTask {
    public static void main(String[] args) {

        // Print header only once
        System.out.println("Student Information");
        System.out.println("-------------------");

        // First student
        Student student1 = new Student();
        student1.name = "Ana Cruz";
        student1.age = 20;
        student1.course = "BSIT";

        // Second student
        Student student2 = new Student();
        student2.name = "Mark Santos";
        student2.age = 21;
        student2.course = "BSCS";

        // Display students
        student1.displayInfo();
        student2.displayInfo();

    }
}
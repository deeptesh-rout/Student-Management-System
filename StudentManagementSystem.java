import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Student {

    private String name;
    private int rollNumber;
    private int age;
    private double grade;

    public Student(String name, int rollNumber, int age, double grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Age: " + age + ", Grade: " + grade;
    }
}




public class StudentManagementSystem {
    
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        
        while (isRunning) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Calculate Average Grade");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    calculateAverageGrade();
                    break;
                case 6:
                    isRunning = false;
                    System.out.println("thank you ..exiting ");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        scanner.close(); 

    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();

        Student student = new Student(name, rollNumber, age, grade);
        students.add(student);
        System.out.println("Student added successfully!");

    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\nStudents:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void updateStudent() {
        System.out.print("Enter roll number of student to update: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 

        Iterator<Student> iterator = students.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRollNumber() == rollNumber) {
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new age: ");
                int age = scanner.nextInt();
                System.out.print("Enter new grade: ");
                double grade = scanner.nextDouble();

                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter roll number of student to delete: ");
        int rollNumber = scanner.nextInt();

        Iterator<Student> iterator = students.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRollNumber() == rollNumber) {
                iterator.remove();
                System.out.println("Student deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    private static void calculateAverageGrade() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        double totalGrade = 0;
        for (Student student : students) {
            totalGrade += student.getGrade();
        }
        double averageGrade = totalGrade / students.size();
        System.out.println("Average Grade: " + averageGrade);
    }
}

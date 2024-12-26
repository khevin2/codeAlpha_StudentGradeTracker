import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;


public class CalculateGrade {
    public static void main(String args[]) throws IOException {
        System.out.println("Hello, welcome to the Student Grade Tracker!");
        System.out.println("Please choose an option:");
        System.out.println("1. Add student grades");
        System.out.println("2. Print the highest grade");
        System.out.println("3. Print the lowest grade");
        System.out.println("4. Print the average grade");
        System.out.println("5. Print the student list");
        System.out.println("6. Exit the program");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                scanner.nextLine(); // consume the newline character
                System.out.println("Enter student name: ");
                String studentName = scanner.nextLine();
                System.out.println("Enter student grade: ");
                double studentGrade = scanner.nextDouble();
                Student student = new Student(studentName, studentGrade);
                addGrades(student);
                break;
            case 2:
                printHighestGrade();
                break;
            case 3:
                printLowestGrade();
                break;
            case 4:
                printAverageGrade();
                break;
            case 5:
                printStudentList();
                break;
            case 6:
                System.out.println("Exiting the program...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        scanner.close();
    }

    static void addGrades(Student student) throws IOException {
        // add functionality to add student grades and save them in student_records.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("student_records.txt", true))) {
            writer.write(student.getStudentName() + ": " + student.getStudentGrade());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printHighestGrade() throws IOException {
        // add functionality to print the highest grade from student_records.txt
        try {
            // read the file
            double highestGrade = 0;
            Scanner scanner = new Scanner(new File("student_records.txt"));
            Student highestScore = new Student();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(": ");
                String studentName = parts[0];
                double studentGrade = Double.parseDouble(parts[1]);
                if (studentGrade > highestGrade) {
                    highestGrade = studentGrade;
                    highestScore.setStudentName(studentName);
                    highestScore.setStudentGrade(studentGrade);
                }
            }
            // print the highest grade
            System.out.println("The highest grade is: " + highestScore.getStudentName() + " with a grade of "
                    + highestScore.getStudentGrade());
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printLowestGrade() throws IOException {
        // add functionality to print the lowest grade from student_records.txt
        try {
            // read the file
            double lowestGrade = 100;
            Scanner scanner = new Scanner(new File("student_records.txt"));
            Student lowestScore = new Student();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(": ");
                String studentName = parts[0];
                double studentGrade = Double.parseDouble(parts[1]);
                if (studentGrade < lowestGrade) {
                    lowestGrade = studentGrade;
                    lowestScore.setStudentName(studentName);
                    lowestScore.setStudentGrade(studentGrade);
                }
            }
            scanner.close();
            // print the lowest grade
            System.out.println("The lowest grade is: " + lowestScore.getStudentName() + " with a grade of "
                    + lowestScore.getStudentGrade());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printAverageGrade() throws IOException {
        // add functionality to print the average grade from student_records.txt
        try {
            // read the file
            double totalGrade = 0;
            int count = 0;
            Scanner scanner = new Scanner(new File("student_records.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(": ");
                double studentGrade = Double.parseDouble(parts[1]);
                totalGrade += studentGrade;
                count++;
            }
            // print the average grade
            scanner.close();
            System.out.println("The average grade is: " + totalGrade / count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void printStudentList() {
        // add functionality to print the list of students and their grades from student_records.txt
        try {
            // read the file
            Scanner scanner = new Scanner(new File("student_records.txt"));
            System.out.println("Student List:");
            System.out.println("-------------");
            System.out.println("Name:\t Grade");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
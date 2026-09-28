package src;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Student Grade Tracker
 * A simple console program to enter student marks and view a summary report.
 */
public class StudentGradeTracker {

    // Two lists kept in sync: the student at index i has name names.get(i) and marks grades.get(i)
    private static final ArrayList<String> names = new ArrayList<>();
    private static final ArrayList<Double> grades = new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("      STUDENT GRADE TRACKER");
        System.out.println("=================================");

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayReport();
                    break;
                case 3:
                    displayStatistics();
                    break;
                case 4:
                    running = false;
                    System.out.println("\nThank you for using Student Grade Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n--------- MAIN MENU ---------");
        System.out.println("1. Add a student");
        System.out.println("2. View summary report");
        System.out.println("3. View statistics");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Reads the menu choice as text first, so typing letters does not crash the program
    private static int readMenuChoice() {
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // treated as an invalid choice by the switch
        }
    }

    private static void addStudent() {
        System.out.println("\n--- Add Student ---");

        String name = readName();
        double marks = readMarks("Enter marks for " + name + " (0-100): ");

        names.add(name);
        grades.add(marks);

        System.out.println("Student added successfully!");
    }

    // Keeps asking until the user types a non-empty name
    private static String readName() {
        while (true) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Name cannot be empty. Please try again.");
        }
    }

    // Keeps asking until the user types a valid number between 0 and 100
    private static double readMarks(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double marks = Double.parseDouble(input);
                if (marks >= 0 && marks <= 100) {
                    return marks;
                }
                System.out.println("Invalid marks. Please enter a value between 0 and 100.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void displayReport() {
        if (names.isEmpty()) {
            System.out.println("\nNo students have been added yet.");
            return;
        }

        System.out.println("\n========== STUDENT SUMMARY REPORT ==========");
        System.out.printf("%-5s %-25s %10s%n", "No.", "Name", "Marks");
        System.out.println("--------------------------------------------");

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%-5d %-25s %10.2f%n", i + 1, names.get(i), grades.get(i));
        }

        System.out.println("--------------------------------------------");
        System.out.println("Total students: " + names.size());
        System.out.printf("Class average : %.2f%n", calculateAverage());
        System.out.println("============================================");
    }

    private static void displayStatistics() {
        if (names.isEmpty()) {
            System.out.println("\nNo students have been added yet.");
            return;
        }

        int highestIndex = findHighestIndex();
        int lowestIndex = findLowestIndex();

        System.out.println("\n------------- STATISTICS -------------");
        System.out.println("Total students : " + names.size());
        System.out.printf("Average score  : %.2f%n", calculateAverage());
        System.out.printf("Highest score  : %.2f (%s)%n", grades.get(highestIndex), names.get(highestIndex));
        System.out.printf("Lowest score   : %.2f (%s)%n", grades.get(lowestIndex), names.get(lowestIndex));
        System.out.println("--------------------------------------");
    }

    private static double calculateAverage() {
        double total = 0;
        for (double mark : grades) {
            total += mark;
        }
        return total / grades.size();
    }

    // Returns the position of the student with the highest marks
    private static int findHighestIndex() {
        int highestIndex = 0;
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) > grades.get(highestIndex)) {
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    // Returns the position of the student with the lowest marks
    private static int findLowestIndex() {
        int lowestIndex = 0;
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) < grades.get(lowestIndex)) {
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }
}
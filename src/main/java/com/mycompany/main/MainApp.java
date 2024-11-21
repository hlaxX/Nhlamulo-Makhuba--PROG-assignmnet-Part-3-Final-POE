package com.mycompany.main;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TaskManager taskManager = new TaskManager();
            
            
            taskManager.addTask(new Task("Create Login", "Mike Smith", "Completed", 101, 5));
            taskManager.addTask(new Task("Update Database", "Edward Harrington", "In Progress", 102, 7));
            taskManager.addTask(new Task("Create Reports", "Samantha Paulson", "In Progress", 103, 6));
            taskManager.addTask(new Task("Fix Bugs", "Glenda Oberholzer", "Not Started", 104, 4));



            
            System.out.println("Welcome to the Task Management System!");
            boolean running = true;
            
            while (running) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Display Developers");
                System.out.println("2. Display Task with Longest Duration");
                System.out.println("3. Search for a Task by Name");
                System.out.println("4. Search All Tasks Assigned to a Developer");
                System.out.println("5. Delete a Task by Name");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                
                
                int choice = 0;
                boolean validChoice = false;
                while (!validChoice) {
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        scanner.nextLine(); 
                        validChoice = true;
                    } else {
                        System.out.println("Invalid input! Please enter a number.");
                        scanner.nextLine(); 
                    }
                }
                
                switch (choice) {
                    case 1 -> taskManager.displayDevelopers();
                    case 2 -> taskManager.findLongestDurationTask();
                    case 3 -> {
                        System.out.print("Enter the name of the task to search: ");
                        String taskName = scanner.nextLine();
                        taskManager.searchTaskByName(taskName);
                    }
                    case 4 -> {
                        System.out.print("Enter the developer's name to search tasks: ");
                        String developerName = scanner.nextLine();
                        taskManager.searchTasksByDeveloper(developerName);
                    }
                    case 5 -> {
                        System.out.print("Enter the name of the task to delete: ");
                        String taskToDelete = scanner.nextLine();
                        taskManager.deleteTask(taskToDelete);
                    }
                    case 6 -> {
                        running = false;
                        System.out.println("Exiting the Task Management System. Goodbye!");
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}

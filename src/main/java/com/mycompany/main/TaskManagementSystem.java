/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManagementSystem {

    
    static class Task {
        String taskName;
        String developerName;
        int taskId;
        int duration;
        String status;

        Task(String taskName, String developerName, int taskId, int duration, String status) {
            this.taskName = taskName;
            this.developerName = developerName;
            this.taskId = taskId;
            this.duration = duration;
            this.status = status;
        }
    }

    
    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            initializeData(); 
            
            System.out.println("Welcome to the Task Management System!");
            boolean running = true;
            
            while (running) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Display Developer Array");
                System.out.println("2. Display Task with Longest Duration");
                System.out.println("3. Search for a Task by Name");
                System.out.println("4. Search All Tasks Assigned to a Developer");
                System.out.println("5. Delete a Task by Name");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1 -> displayDeveloperArray();
                    case 2 -> findLongestDurationTask();
                    case 3 -> {
                        System.out.print("Enter the name of the task to search: ");
                        String taskName = scanner.nextLine();
                        searchTaskByName(taskName);
                    }
                    case 4 -> {
                        System.out.print("Enter the developer's name to search tasks: ");
                        String developerName = scanner.nextLine();
                        searchTasksByDeveloper(developerName);
                    }
                    case 5 -> {
                        System.out.print("Enter the name of the task to delete: ");
                        String taskToDelete = scanner.nextLine();
                        deleteTask(taskToDelete);
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

    
    private static void initializeData() {
        tasks.add(new Task("Create Login", "Mike Smith", 101, 5, "Completed"));
        tasks.add(new Task("Update Database", "Edward Harrington", 102, 8, "In Progress"));
        tasks.add(new Task("Create Reports", "Samantha Paulson", 103, 6, "In Progress"));
        tasks.add(new Task("Fix Bugs", "Glenda Oberholzer", 104, 11, "Not Started"));
    }

    
    private static void displayDeveloperArray() {
        System.out.println("\nDevelopers in the system:");
        for (Task task : tasks) {
            System.out.println("- " + task.developerName);
        }
    }

    
    private static void findLongestDurationTask() {
        if (!tasks.isEmpty()) {
            Task longestTask = tasks.stream()
                .max((t1, t2) -> Integer.compare(t1.duration, t2.duration))
                .orElse(null);
            if (longestTask != null) {
                System.out.println("\nTask with the longest duration:");
                System.out.println("Developer: " + longestTask.developerName);
                System.out.println("Task: " + longestTask.taskName);
                System.out.println("Duration: " + longestTask.duration + " hours");
            }
        } else {
            System.out.println("No tasks available.");
        }
    }

    
    private static void searchTaskByName(String taskName) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.taskName.equalsIgnoreCase(taskName)) {
                System.out.println("\nTask found:");
                System.out.println("Developer: " + task.developerName);
                System.out.println("Task: " + task.taskName);
                System.out.println("Status: " + task.status);
                System.out.println("Duration: " + task.duration + " hours");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Task not found.");
        }
    }

    
    private static void searchTasksByDeveloper(String developerName) {
        System.out.println("\nTasks assigned to " + developerName + ":");
        boolean found = false;
        for (Task task : tasks) {
            if (task.developerName.equalsIgnoreCase(developerName)) {
                System.out.println("- " + task.taskName + " (" + task.status + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found for this developer.");
        }
    }

    
    private static void deleteTask(String taskName) {
        Task taskToDelete = null;
        for (Task task : tasks) {
            if (task.taskName.equalsIgnoreCase(taskName)) {
                taskToDelete = task;
                break;
            }
        }
        if (taskToDelete != null) {
            tasks.remove(taskToDelete);
            System.out.println("Task '" + taskName + "' successfully deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }
}


package com.mycompany.main;

import java.util.ArrayList;

public class TaskManager {
    private final ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

   
    public void addTask(Task task) {
        tasks.add(task);
    }

    
    public void displayDevelopers() {
        System.out.println("\nDevelopers:");
        for (Task task : tasks) {
            System.out.println("- " + task.getDeveloperName());
        }
    }

    
    public void findLongestDurationTask() {
        if (!tasks.isEmpty()) {
            Task longestTask = tasks.stream().max((t1, t2) -> Integer.compare(t1.getDuration(), t2.getDuration())).orElse(null);
            System.out.println("\nTask with the longest duration:");
            System.out.println(longestTask);
        } else {
            System.out.println("No tasks available.");
        }
    }

    
    public void searchTaskByName(String taskName) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                System.out.println("\nTask found:");
                System.out.println(task);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Task not found.");
        }
    }

    
    public void searchTasksByDeveloper(String developerName) {
        System.out.println("\nTasks assigned to " + developerName + ":");
        boolean found = false;
        for (Task task : tasks) {
            if (task.getDeveloperName().equalsIgnoreCase(developerName)) {
                System.out.println("- " + task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found for this developer.");
        }
    }

    
    public void deleteTask(String taskName) {
        Task taskToDelete = null;
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                taskToDelete = task;
                break;
            }
        }

        if (taskToDelete != null) {
            tasks.remove(taskToDelete);
            System.out.println("Task deleted: " + taskName);
        } else {
            System.out.println("Task not found.");
        }
    }
}


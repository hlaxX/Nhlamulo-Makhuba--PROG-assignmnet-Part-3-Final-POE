package com.mycompany.main;

public class Task {
    String taskName;
    String developerName;
    int taskId;
    int duration;
    String status;

    
    public Task(String taskName, String developerName, String status, int taskId, int duration) {
        this.taskName = taskName;
        this.developerName = developerName;
        this.status = status;
        this.taskId = taskId;
        this.duration = duration;
    }

    
    public String getTaskName() {
        return taskName;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    
    public void displayTaskDetails() {
        System.out.println("Task Name: " + taskName);
        System.out.println("Assigned to: " + developerName);
        System.out.println("Task ID: " + taskId);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Status: " + status);
    }

    
    public boolean checkTaskDescription() {
        return taskName.length() <= 50; 
    }

    
    public Integer createTaskID() {
        return this.taskId; 
    }

    
    public String printTaskDetails() {
        return String.format("Task Name: %s, Assigned to: %s, Task ID: %d, Duration: %d hours, Status: %s",
                taskName, developerName, taskId, duration, status);
    }

    int getTaskDuration() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

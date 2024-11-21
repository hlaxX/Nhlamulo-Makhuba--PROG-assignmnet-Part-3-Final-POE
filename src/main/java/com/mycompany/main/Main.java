package com.mycompany.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Login loginSystem = new Login();
    private static final List<Task> tasks = new ArrayList<>();
    private static final List<String> developerArray = new ArrayList<>();
    private static final List<String> taskNameArray = new ArrayList<>();
    private static final List<Integer> taskIdArray = new ArrayList<>();
    private static final List<Integer> taskDurationArray = new ArrayList<>();
    private static final List<String> taskStatusArray = new ArrayList<>();
    private static int taskIdCounter = 1; 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("EasyKanban");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 700);
            frame.setLayout(new BorderLayout());

            JLabel welcomeLabel = new JLabel("Welcome to EasyKanban", SwingConstants.CENTER);
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
            frame.add(welcomeLabel, BorderLayout.NORTH);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JTextField usernameField = new JTextField(20);
            JTextField passwordField = new JTextField(20);
            JTextField firstNameField = new JTextField(20);
            JTextField lastNameField = new JTextField(20);
            JButton registerButton = new JButton("Register");
            JButton loginButton = new JButton("Login");
            JButton addTaskButton = new JButton("Add Task");
            JButton showReportButton = new JButton("Show Report");
            JButton doneTasksButton = new JButton("Show 'Done' Tasks");
            JButton longestTaskButton = new JButton("Longest Task");
            JButton searchTaskButton = new JButton("Search Task");
            JButton deleteTaskButton = new JButton("Delete Task");
            JTextArea outputArea = new JTextArea(15, 40);
            outputArea.setEditable(false);

            panel.add(new JLabel("Username:"));
            panel.add(usernameField);
            panel.add(new JLabel("Password:"));
            panel.add(passwordField);
            panel.add(new JLabel("First Name:"));
            panel.add(firstNameField);
            panel.add(new JLabel("Last Name:"));
            panel.add(lastNameField);
            panel.add(registerButton);
            panel.add(loginButton);
            panel.add(addTaskButton);
            panel.add(showReportButton);
            panel.add(doneTasksButton);
            panel.add(longestTaskButton);
            panel.add(searchTaskButton);
            panel.add(deleteTaskButton);
            panel.add(new JScrollPane(outputArea));

            frame.add(panel, BorderLayout.CENTER);
            frame.setVisible(true);

            
            registerButton.addActionListener((var e) -> {
                String username = usernameField.getText();
                String password = passwordField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                loginSystem.registerUser(username, password, firstName, lastName);
                outputArea.append("Registration successful!\n");
            });

            
            loginButton.addActionListener(e -> {
                String username = usernameField.getText();
                String password = passwordField.getText();
                if (loginSystem.loginUser(username, password)) {
                    outputArea.append("Login successful!\n");
                    addTaskButton.setEnabled(true);
                } else {
                    outputArea.append("Login failed!\n");
                }
            });

            
            addTaskButton.addActionListener(e -> {
                if (!loginSystem.isLoggedIn()) {
                    outputArea.append("Please log in first!\n");
                    return;
                }
                String taskName = JOptionPane.showInputDialog(frame, "Enter Task Name:");
                String taskDescription = JOptionPane.showInputDialog(frame, "Enter Task Description (max 50 characters):");
                String developerName = JOptionPane.showInputDialog(frame, "Enter Developer Name:");
                String durationStr = JOptionPane.showInputDialog(frame, "Enter Task Duration (hours):");
                int taskDuration = Integer.parseInt(durationStr);
                String[] options = {"To Do", "Doing", "Done"};
                String taskStatus = (String) JOptionPane.showInputDialog(frame, "Select Task Status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (taskDescription != null && taskDescription.length() <= 50) {
                    int newTaskId = taskIdCounter++; // Increment taskId counter to get a unique task ID
                    Task newTask = new Task(taskName, developerName, taskStatus, newTaskId, taskDuration);

                    tasks.add(newTask);
                    developerArray.add(developerName);
                    taskNameArray.add(taskName);
                    taskIdArray.add(newTask.createTaskID());
                    taskDurationArray.add(taskDuration);
                    taskStatusArray.add(taskStatus);
                    outputArea.append("Task added successfully!\n");
                } else {
                    outputArea.append("Task description exceeds 50 characters.\n");
                }
            });

            
            showReportButton.addActionListener(e -> {
                if (tasks.isEmpty()) {
                    outputArea.append("No tasks available.\n");
                } else {
                    outputArea.append("Report of all tasks:\n");
                    for (Task task : tasks) {
                        outputArea.append(task.printTaskDetails() + "\n");
                    }
                }
            });

            
            doneTasksButton.addActionListener(e -> {
                outputArea.append("Tasks with status 'Done':\n");
                for (int i = 0; i < taskStatusArray.size(); i++) {
                    if ("Done".equals(taskStatusArray.get(i))) {
                        outputArea.append("Developer: " + developerArray.get(i) + ", Task: " + taskNameArray.get(i) + ", Duration: " + taskDurationArray.get(i) + " hours\n");
                    }
                }
            });

            
            longestTaskButton.addActionListener(e -> {
                int maxDuration = taskDurationArray.stream().max(Integer::compare).orElse(0);
                int index = taskDurationArray.indexOf(maxDuration);
                outputArea.append("Task with the longest duration:\n");
                outputArea.append("Developer: " + developerArray.get(index) + ", Task: " + taskNameArray.get(index) + ", Duration: " + maxDuration + " hours\n");
            });

            
            searchTaskButton.addActionListener(e -> {
                String searchName = JOptionPane.showInputDialog(frame, "Enter Task Name to search:");
                for (int i = 0; i < taskNameArray.size(); i++) {
                    if (taskNameArray.get(i).equalsIgnoreCase(searchName)) {
                        outputArea.append("Task found:\n");
                        outputArea.append("Task Name: " + taskNameArray.get(i) + ", Developer: " + developerArray.get(i) + ", Status: " + taskStatusArray.get(i) + "\n");
                    }
                }
            });

            
            deleteTaskButton.addActionListener(e -> {
                String deleteName = JOptionPane.showInputDialog(frame, "Enter Task Name to delete:");
                int indexToRemove = taskNameArray.indexOf(deleteName);
                if (indexToRemove != -1) {
                    developerArray.remove(indexToRemove);
                    taskNameArray.remove(indexToRemove);
                    taskIdArray.remove(indexToRemove);
                    taskDurationArray.remove(indexToRemove);
                    taskStatusArray.remove(indexToRemove);
                    outputArea.append("Task deleted successfully.\n");
                } else {
                    outputArea.append("Task not found.\n");
                }
            });
        });
    }
}


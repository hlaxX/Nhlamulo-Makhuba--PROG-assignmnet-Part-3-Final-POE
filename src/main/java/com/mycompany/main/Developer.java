/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;

public class Developer {
    private String name;
    private ArrayList<Task> tasks;

    public Developer(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    
    public String getName() {
        return name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public String toString() {
        return "Developer: " + name + ", Tasks: " + tasks.size();
    }
}


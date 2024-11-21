package com.mycompany.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testCheckTaskDescriptionSuccess() {
        Task task = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, 101);
        assertTrue(task.checkTaskDescription(), "Task description should be valid (less than 50 characters)");
    }

    @Test
    public void testCheckTaskDescriptionFailure() {
        Task task = new Task("Add Task Feature", "This description is way too long to be valid since it exceeds fifty characters", "Mike Smith", 10, 5);
        assertFalse(task.checkTaskDescription(), "Task description should be invalid (more than 50 characters)");
    }

    @Test
    public void testCreateTaskID() {
        Task task = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, 1);
        assertEquals("LO:0:SON", task.createTaskID(), "Task ID should match expected format LO:0:SON");
    }

    @Test
    public void testCreateTaskIDMultipleTasks() {
        Task task1 = new Task("Add Task Feature", "Add task functionality", "Mike Smith", 10 , 1);
        Task task2 = new Task("Remove Task Feature", "Remove task functionality", "Alice Wonderland", 12, 4);
        Task task3 = new Task("Update Task Feature", "Update task functionality", "John Doe", 5, 4);

        assertEquals("AD:0:ITH", task1.createTaskID(), "Task ID for task1 should match AD:0:ITH");
        assertEquals("RE:1:AND", task2.createTaskID(), "Task ID for task2 should match RE:1:AND");
        assertEquals("UP:2:DOE", task3.createTaskID(), "Task ID for task3 should match UP:2:DOE");
    }

    @Test
    public void testReturnTotalHours() {
        Task task1 = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, 1);
        Task task2 = new Task("Add Task Feature", "Add task functionality", "Mike Smith", 10, 1);

        int totalHours = task1.getTaskDuration() + task2.getTaskDuration();
        assertEquals(18, totalHours, "Total hours should be 18 for task1 and task2");
    }
}


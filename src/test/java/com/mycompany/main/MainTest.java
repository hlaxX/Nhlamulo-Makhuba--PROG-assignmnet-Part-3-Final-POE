/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testValidUsername() {
        Login system = new Login();
        String validUsername = "kyl_1";
        assertTrue(system.validateUsername(validUsername));
    }

    @Test
    public void testInvalidUsername() {
        Login system = new Login();
        String invalidUsername = "kyle!!!!";
        assertFalse(system.validateUsername(invalidUsername));
    }

    @Test
    public void testValidPassword() {
        Login system = new Login();
        String validPassword = "Ch&&sec@ke99!";
        assertTrue(system.validatePassword(validPassword));
    }

    @Test
    public void testInvalidPassword() {
        Login system = new Login();
        String invalidPassword = "password";
        assertFalse(system.validatePassword(invalidPassword));
    }

    @Test
    public void testSuccessfulLogin() {
        Login system = new Login();
        system.registerUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        assertTrue(system.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testFailedLogin() {
        Login system = new Login();
        system.registerUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        assertFalse(system.loginUser("kyl_1", "wrongpassword"));
    }
}



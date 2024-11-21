/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testUsernameValidation() {
        Login system = new Login();
        assertTrue(system.validateUsername("kyl_1"));
        assertFalse(system.validateUsername("kyle"));
    }

    @Test
    public void testPasswordValidation() {
        Login system = new Login();
        assertTrue(system.validatePassword("Ch&&sec@ke99!"));
        assertFalse(system.validatePassword("password"));
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


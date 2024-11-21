/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.main;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class MainIT {

    @Test
    public void testMain() {
        String[] args = null;
        try {
            Main.main(args);
        } catch (Exception e) {
            fail("The main method should not throw exceptions");
        }
    }
}


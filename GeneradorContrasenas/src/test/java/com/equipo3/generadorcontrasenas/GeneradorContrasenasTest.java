/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.equipo3.generadorcontrasenas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author Equipo3
 */
public class GeneradorContrasenasTest {
    
    public GeneradorContrasenasTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of generarContrasena method, of class GeneradorContrasenas.
     */
    @Test
    public void testGenerarContrasena() {
        System.out.println("Generar Contrasena Segura");
        int longitud = 8;
        GeneradorContrasenas instance = new GeneradorContrasenas();
        NivelSeguridad expResult = NivelSeguridad.ALTO;
        NivelSeguridad result = new EvaluadorContrasenas().verificarSeguridad(instance.generarContrasena(longitud));
        assertEquals(expResult, result);
    }
    
}

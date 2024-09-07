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
public class EvaluadorContrasenasTest {
    
    public EvaluadorContrasenasTest() {
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
     * Test of verificarSeguridad method, of class EvaluadorContrasenas.
     */
    @Test
    public void testVerificarSeguridad_BAJO() {
        String contrasena = "kaskakkks";
        EvaluadorContrasenas instance = new EvaluadorContrasenas();
        NivelSeguridad expResult = NivelSeguridad.BAJO;
        NivelSeguridad result = instance.verificarSeguridad(contrasena);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testVerificarSeguridad_MEDIO() {
        String contrasena = "kaskakkksAAAA";
        EvaluadorContrasenas instance = new EvaluadorContrasenas();
        NivelSeguridad expResult = NivelSeguridad.MEDIO;
        NivelSeguridad result = instance.verificarSeguridad(contrasena);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testVerificarSeguridad_ALTO() {
        String contrasena = "kaskakkksAAA1012^^A";
        EvaluadorContrasenas instance = new EvaluadorContrasenas();
        NivelSeguridad expResult = NivelSeguridad.ALTO;
        NivelSeguridad result = instance.verificarSeguridad(contrasena);
        assertEquals(expResult, result);
    }
}

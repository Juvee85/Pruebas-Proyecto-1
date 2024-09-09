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
    public void testGenerarContrasenaCorta() {
        System.out.println("[*] Generar y verificar una contrasena de 8 caracteres");
        int longitud = 8;
        GeneradorContrasenas instance = new GeneradorContrasenas();
        NivelSeguridad expResult = NivelSeguridad.ALTO;
        String contrasena = instance.generarContrasena(longitud);
        System.out.println("Contrasena Generada: " + contrasena);
        EvaluadorContrasenas evaluador = new EvaluadorContrasenas();
        NivelSeguridad result = evaluador.verificarSeguridad(contrasena);
        System.out.println("Seguridad: " + result.toString());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGenerarContrasenaMediana() {
        System.out.println("[*] Generar y verificar una contrasena de 16 caracteres");
        int longitud = 16;
        GeneradorContrasenas instance = new GeneradorContrasenas();
        NivelSeguridad expResult = NivelSeguridad.ALTO;
        String contrasena = instance.generarContrasena(longitud);
        System.out.println("Contrasena Generada: " + contrasena);
        EvaluadorContrasenas evaluador = new EvaluadorContrasenas();
        NivelSeguridad result = evaluador.verificarSeguridad(contrasena);
        System.out.println("Seguridad: " + result.toString());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGenerarContrasenaLarga() {
        System.out.println("[*] Generar y verificar una contrasena de 32 caracteres");
        int longitud = 32;
        GeneradorContrasenas instance = new GeneradorContrasenas();
        NivelSeguridad expResult = NivelSeguridad.ALTO;
        String contrasena = instance.generarContrasena(longitud);
        System.out.println("Contrasena Generada: " + contrasena);
        EvaluadorContrasenas evaluador = new EvaluadorContrasenas();
        NivelSeguridad result = evaluador.verificarSeguridad(contrasena);
        System.out.println("Seguridad: " + result.toString());
        assertEquals(expResult, result);
    }
}

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
public class EvaluadorContrasenasSecuencialTest {
    
    public EvaluadorContrasenasSecuencialTest() {
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

    @Test
    public void testVerificarSeguridad_BAJO() {
        System.out.println("[*] Verificar Contrasena de Baja Seguridad de manera Secuencial");
        String contrasena = "1224123";
        System.out.println("Contrasena a probar: " + contrasena);
        IEvaluadorContrasenas instance = new EvaluadorContrasenasSecuencial();
        NivelSeguridad expResult = NivelSeguridad.BAJO;
        NivelSeguridad result = instance.verificarSeguridad(contrasena);
        System.out.println("Seguridad: " + result.toString());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testVerificarSeguridad_MEDIO() {
        System.out.println("[*] Verificar Contrasena de Seguridad Media de manera Secuencial");
        String contrasena = "potros1224123";
        System.out.println("Contrasena a probar: " + contrasena);
        IEvaluadorContrasenas instance = new EvaluadorContrasenasSecuencial();
        NivelSeguridad expResult = NivelSeguridad.MEDIO;
        NivelSeguridad result = instance.verificarSeguridad(contrasena);
        System.out.println("Seguridad: " + result.toString());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testVerificarSeguridad_ALTO() {
        System.out.println("[*] Verificar Contrasena de Alta Seguridad de manera Secuencial");
        String contrasena = "potros4123$#!1AAdo21";
        System.out.println("Contrasena a probar: " + contrasena);
        IEvaluadorContrasenas instance = new EvaluadorContrasenasSecuencial();
        NivelSeguridad expResult = NivelSeguridad.ALTO;
        NivelSeguridad result = instance.verificarSeguridad(contrasena);
        System.out.println("Seguridad: " + result.toString());
        assertEquals(expResult, result);
    }
}

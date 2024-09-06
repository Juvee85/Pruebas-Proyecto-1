/*
 * EvaluadorContrasenas.java
 */
package com.equipo3.generadorcontrasenas;

import java.util.regex.Pattern;

/**
 * 
 * @author Equipo 3
 */
public class EvaluadorContrasenasSecuencial implements IEvaluadorContrasenas {

    // TODO: Se puede poner dentro de un map<Nombre Prueba, Patron que debe cumplir>
    // y verificar una a una si cumple o no con las pruebas (en caso de ser varias)
    private static final Pattern MAYUSCULAS = Pattern.compile("[A-Z]");
    private static final Pattern MINUSCULAS = Pattern.compile("[a-z]");
    private static final Pattern NUMEROS = Pattern.compile("[0-9]");
    private static final Pattern CARACTERES_ESPECIALES = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]");
    private static final int PASOS_TOTALES = 4;
    
    @Override
    public NivelSeguridad verificarSeguridad(String contrasena) {
        
        int pasosCompletados = 0;
        
        boolean pasoValido = MAYUSCULAS.matcher(contrasena).find();
        if (pasoValido) {
            System.out.println("[*] Caracteres en mayuscula detectados!");
            pasosCompletados++;
        } else {
            System.out.println("[x] NO contiene mayusculas!");
        }
        
        pasoValido = MINUSCULAS.matcher(contrasena).find();
        if (pasoValido) {
            System.out.println("[*] Caracteres en minuscula detectados!");
            pasosCompletados++;
        } else {
            System.out.println("[x] NO contiene minusculas!");
        }
        
        pasoValido = NUMEROS.matcher(contrasena).find();
        if (pasoValido) {
            System.out.println("[*] Caracteres numericos detectados!");
            pasosCompletados++;
        } else {
            System.out.println("[x] NO contiene caracteres numericos!");
        }
        
        pasoValido = CARACTERES_ESPECIALES.matcher(contrasena).find();
        if (pasoValido) {
            System.out.println("[*] Caracteres especiales detectados (simbolos)!");
            pasosCompletados++;
        } else {
            System.out.println("[x] NO contiene caracteres especiales (simbolos)!");
        }
        
        if (pasosCompletados < 2 && pasosCompletados >= 0) {
            return NivelSeguridad.BAJO;
        } 
        else if (pasosCompletados > 1 && pasosCompletados < PASOS_TOTALES) {
            return NivelSeguridad.MEDIO;
        }
        
        return NivelSeguridad.ALTO;
    }
}

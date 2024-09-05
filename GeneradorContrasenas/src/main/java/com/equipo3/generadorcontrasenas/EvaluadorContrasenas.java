/*
 * EvaluadorContrasenas.java
 */
package com.equipo3.generadorcontrasenas;

/**
 * 
 * @author Equipo 3
 */
public class EvaluadorContrasenas implements IEvaluadorContrasenas {

    @Override
    public NivelSeguridad verificarSeguridad(String contrasena) {
        return NivelSeguridad.BAJO;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.equipo3.generadorcontrasenas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Equipo3
 */
public class GeneradorContrasenas {
    
    public Map<String, String> contrasenasGuardadas;
    public List<String> algoritmosDisponibles;
    
    public GeneradorContrasenas() {
        this.contrasenasGuardadas = new HashMap<>();
        this.algoritmosDisponibles = new ArrayList<>();
        
        this.algoritmosDisponibles.add("SHA-224");
        this.algoritmosDisponibles.add("SHA-256");
        this.algoritmosDisponibles.add("SHA-384");
        this.algoritmosDisponibles.add("SHA-512");
        this.algoritmosDisponibles.add("SHA-512/224");
        this.algoritmosDisponibles.add("SHA-512/256");
        this.algoritmosDisponibles.add("SHA3-224");
        this.algoritmosDisponibles.add("SHA3-256");
        this.algoritmosDisponibles.add("SHA3-384");
        this.algoritmosDisponibles.add("SHA3-512");
    }
    
    public List<String> obtenerAlgoritmosDisponibles() {
        return this.algoritmosDisponibles;
    }
    
    public String obtenerNombreAlgoritmo(int posicion) {
        return this.algoritmosDisponibles.get(posicion);
    }
    
    public void guardarContrasena(String nombreContrasena, String contrasena) {
        this.contrasenasGuardadas.put(nombreContrasena, contrasena);
    }
    
    public String obtenerContrasena(String nombre) {
        return this.contrasenasGuardadas.get(nombre);
    }
    
    public Iterator<String> getContrasenasGuardadas() {
        return this.contrasenasGuardadas.values().iterator();
    }
}

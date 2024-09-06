/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.equipo3.generadorcontrasenas;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Equipo3
 */
public class GeneradorContrasenas implements IGeneradorContrasenas {

    public List<String> algoritmosDisponibles;

    public GeneradorContrasenas() {
        //this.contrasenasGuardadas = new HashMap<>();
        this.algoritmosDisponibles = new ArrayList<>();
        /*
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
        */
    }

    @Override
    public String generarContrasena(int longitud) {
        Random random = new SecureRandom();
        StringBuilder contrasena = new StringBuilder();

        int cantidadMayusculas = longitud * 20 / 100;
        int cantidadNumeros = longitud * 30 / 100;
        int cantidadEspeciales = longitud * 20 / 100;
        int cantidadMinusculas = longitud - (cantidadMayusculas + cantidadNumeros
                + cantidadEspeciales);

        final char[] minusculas = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] mayusculas = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
        final char[] numeros = "0123456789".toCharArray();
        final char[] especiales = "^$?!@#%&".toCharArray();

        for (int i = 0; i < cantidadMayusculas; i++) {
            contrasena.append(mayusculas[random.nextInt(mayusculas.length)]);
        }
        
        for (int i = 0; i < cantidadNumeros; i++) {
            contrasena.insert(random.nextInt(contrasena.length()), 
                    numeros[random.nextInt(numeros.length)]);
        }
        
        for (int i = 0; i < cantidadEspeciales; i++) {
            contrasena.insert(random.nextInt(contrasena.length()), 
                    especiales[random.nextInt(especiales.length)]);
        }
        
        for (int i = 0; i < cantidadMinusculas; i++) {
            contrasena.insert(random.nextInt(contrasena.length()), 
                    minusculas[random.nextInt(minusculas.length)]);
        }
        
        return contrasena.toString();
    }
}

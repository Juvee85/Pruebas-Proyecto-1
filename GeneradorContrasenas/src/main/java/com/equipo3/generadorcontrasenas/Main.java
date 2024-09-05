/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo3.generadorcontrasenas;

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Equipo3
 */
public class Main {
    
    public static final String PATRON_CONTRASENAS = "^[a-zA-Z0-9?_=\\-$%&!]+$";
    
    public static void muestraOpciones() {
        System.out.println("");
        System.out.println("1. Generar Contrasena Encriptada");
        System.out.println("2. Evaluar Contrasena");
        System.out.println("3. Mostrar Contrasenas Guardadas");
        System.out.println("0. Salir");
        System.out.println("");
    }
    
    public static void muestraAlgoritmos(Iterator<String> lista) {
        int i=0;
        while (lista.hasNext()) {
            System.out.printf(String.format("%d. %s\n", i, lista.next()));
            i++;
        }
    }
    
    public static void main(String[] args) {
        GeneradorContrasenas generadorContrasenas = new GeneradorContrasenas();
        Encriptador encriptador;
        
        Pattern patronContrasenaCorrecta = Pattern.compile(Main.PATRON_CONTRASENAS);
  
        Scanner entrada = new Scanner(System.in);
        
        boolean buclePrincipal = true;
        
        while (buclePrincipal) {
            Main.muestraOpciones();
            System.out.print(">>> ");
            int opcion = entrada.nextInt();
        }
    }
}









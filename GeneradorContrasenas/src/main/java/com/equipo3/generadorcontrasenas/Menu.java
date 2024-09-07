/*
 * Menu.java
 */
package com.equipo3.generadorcontrasenas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase que despliega el menu de consola y maneja la selección de opciones del
 * usuario
 *
 * @author Equipo 3
 */
public class Menu {

    private IGeneradorContrasenas generador;
    private IEvaluadorContrasenas evaluador;
    
    private Map<String, String> contrasenasGuardadas;
    
    private Scanner tec = new Scanner(System.in);

    public Menu() {
        generador = new GeneradorContrasenas();
        evaluador = new EvaluadorContrasenas();
        contrasenasGuardadas = new HashMap<>();
    }

    /**
     * Muestra el menu, recibe la opcion selecionada y ejecuta el método
     * correspondiente
     */
    public void desplegarMenu() {
        boolean ejecutar = true;

        do {
            //Despliega el menu
            System.out.println("Bienvenido al generador de contrasenas, "
                    + "seleccione la operacion que desea realizar");
            System.out.println("\t1. Generar Contrasena");
            System.out.println("\t2. Evaluar Contrasena");
            System.out.println("\t3. Mostrar Contrasenas Guardadas");
            System.out.println("\t4. Guardar Contrasena");
            System.out.println("\t0.Salir\n");

            System.out.print(">>> ");
            int opcion = tec.nextInt();

            //Ejecuta la opcion solicitada
            switch (opcion) {
                case 1 ->
                    generarContrasena();
                case 2 ->
                    evaluarContrasena();
                case 3 ->
                    mostrarContrasenas();
                case 4 -> 
                    guardarContrasena();
                case 0 ->
                    ejecutar = false; //Termina el proceso
                default ->
                    System.out.println("Opción no valida, "
                            + "ingrese una del 0 al 3");
            }
        } while (ejecutar);
    }

    /**
     * Ejecuta la generación de una contraseña segura
     */
    private void generarContrasena() {
        System.out.println("Ingrese la longitud que desea para su contrasena (longitud minima: 8): ");
        
        boolean entradaValida = false;
        
        int longitud = 8;
        
        while (!entradaValida) {
            System.out.print(">>> ");
            
            longitud = tec.nextInt();
            
            if (longitud < 8) {
                System.out.println("[!] El tamano de la contrasena debe tener una longitud minima de 8 caracteres...");
                continue;
            }
            
            entradaValida = true;
        }
       
        String contrasena = generador.generarContrasena(longitud);
        System.out.println("Su nueva contraseña segura es: " + contrasena);
        regresar();
    }

    /**
     * Ejecuta la evaluación de una contraseña existente ingresada por el
     * usuario
     */
    private void evaluarContrasena() {
        System.out.println("Ingrese la contraseña que desea evaluar");
        String contrasena = tec.next();

        IEvaluadorContrasenas evaluadorSecuencial = new EvaluadorContrasenasSecuencial();
        
        String nivelSeguridad = evaluadorSecuencial.verificarSeguridad(contrasena).toString();
        
        System.out.println("Su contraseña tiene un nivel de seguridad: "
                + nivelSeguridad);
        
        regresar();
    }
    
    private void guardarContrasena() {
        System.out.println();
        
        boolean entradaValida = false;
        
        String nombreContrasena = "", contrasena = "";
        
        while (!entradaValida) {
            System.out.print("Ingresa el nombre con el que deseas guardar la contrasena[minimo de 4 y menor a 20 caracteres]: ");
            nombreContrasena = tec.next();
            
            if (nombreContrasena.length() < 4 || nombreContrasena.length() > 20) {
                System.out.println("[!] El nombre de la contrasena debe tener al menos 4 y un maximo de 20 caracteres...");
                continue;
            }
            
            entradaValida = true;
        }
        
        entradaValida = false;
        
        while (!entradaValida) {
            System.out.print("Ingresa la contrasena a guardar: ");
            contrasena = tec.next();
            
            if (contrasena.isBlank() || contrasena.isEmpty()) {
                System.out.println("[!] Por favor, ingresa una contrasena");
            }
            
            entradaValida = true;
        }
        
        this.contrasenasGuardadas.put(nombreContrasena, contrasena);
        
        regresar();
    }
    
    private void mostrarContrasenas() {
        System.out.println("Contrasenas guardadas: " + this.contrasenasGuardadas.size());
        
        int i = 1;
        
        for (Map.Entry<String, String> contrasenaGuardada: this.contrasenasGuardadas.entrySet()) {
            String llave = contrasenaGuardada.getKey();
            String contrasena = contrasenaGuardada.getValue();
            String nivelSeguridad = this.evaluador.verificarSeguridad(contrasena).toString();
            System.out.println(String.format("%d. [Nombre: %s]: [PASSWD: %s] [Seguridad: %s]", i, llave, contrasena, nivelSeguridad));
            i++;
        }
        
        regresar();
    }

    /**
     * Pausa la ejecución para esperar la entrada del usuario indicando que
     * desea continuar
     */
    private void regresar() {
        System.out.println("Presione enter para volver");
        tec.nextLine();
        tec.nextLine();
    }
}

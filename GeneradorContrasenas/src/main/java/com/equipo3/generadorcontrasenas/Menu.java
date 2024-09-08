/*
 * Menu.java
 */
package com.equipo3.generadorcontrasenas;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que despliega el menu de consola y maneja la selección de opciones del
 * usuario
 *
 * @author Equipo 3
 */
public class Menu {

    private IGeneradorContrasenas generador;
    private IEvaluadorContrasenas evaluador;
    private static final Pattern PATRON_TEXTO = Pattern.compile("^[a-zA-Z0-9\\S?_=\\-@$%&!^#]+$");
    private static final Pattern PATRON_ESPACIOS = Pattern.compile("\\s");
    
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

            try {
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
                    case 0 -> {
                        System.out.println("[=*=] Saliendo...");
                        ejecutar = false; //Termina el proceso
                    }
                    default ->
                        System.out.println("Opción no valida, "
                                + "ingrese una del 0 al 3");
                }
            } catch (InputMismatchException ex) {
                System.out.println("[!] Ingresa una opcion...");
                tec.nextLine();
            }
        } while (ejecutar);
    }

    /**
     * Ejecuta la generación de una contraseña segura
     */
    private void generarContrasena() {
        boolean entradaValida = false;
        
        int longitud = 8;
        
        while (!entradaValida) {
            try {
                System.out.print("Ingrese la longitud que desea para su contrasena (longitud minima: 8): ");

                longitud = tec.nextInt();

                if (longitud < 8 || longitud > 100) {
                    System.out.println("[!] El tamano de la contrasena debe tener una longitud minima de 8 y un maximo de 100 caracteres...");
                    continue;
                }

                entradaValida = true;
            } catch (InputMismatchException ex) {
                System.out.println("[!] Ingresa un numero...");
                tec.nextLine();
            }
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
        
        String contrasena = "";
        
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                contrasena = tec.next();

                if (this.contieneEspacios(contrasena)) {
                    throw new InputMismatchException("[!] La contrasena no debe contener espacios...");
                }
                
                if (contrasena.length() < 4 || contrasena.length() > 100) {
                    throw new InputMismatchException("[!] La contrasena debe contener un minimo de 4 caracteres y un maximo de 100");
                }
                
                if (!this.entradaTextoValida(contrasena) || (contrasena.isBlank() || contrasena.isBlank())) {
                    throw new InputMismatchException("[!] La contrasena debe contener caracteres ASCII y no debe estar vacia...");
                }
                
                entradaValida = true;
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
                tec.nextLine();
            }
        }
    

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
            try {
                System.out.print("Ingresa el nombre con el que deseas guardar la contrasena[minimo de 4 y menor a 20 caracteres]: ");
                nombreContrasena = tec.next();

                if (nombreContrasena.isBlank() || nombreContrasena.isEmpty()) {
                    throw new InputMismatchException("[!] Ingresa el nombre de la contrasena...");
                }
                
                if (!this.entradaTextoValida(nombreContrasena)) {
                    throw new InputMismatchException("[!] El nombre solo debe contener caracteres ASCII...");
                }
                
                if (nombreContrasena.length() < 4 || nombreContrasena.length() > 20) {
                    throw new InputMismatchException("[!] El nombre de la contrasena debe tener al menos 4 y un maximo de 20 caracteres...");
                }
                
                entradaValida = true;
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
                tec.nextLine();
            }
        }
        
        
        entradaValida = false;
        
        while (!entradaValida) {
            try {
                System.out.print("Ingresa la contrasena a guardar: ");
                contrasena = tec.next();

                if (contrasena.isBlank() || contrasena.isEmpty()) {
                    throw new InputMismatchException("[!] Por favor, ingresa una contrasena");
                }
                
                if (contrasena.length() < 4 || contrasena.length() > 100) {
                    throw new InputMismatchException("[!] La contrasena debe tener al menos 4 caracteres y un maximo de 100...");
                }
                
                if (!this.entradaTextoValida(contrasena)) {
                    throw new InputMismatchException("[!] La contrasena debe contener solo caracteres ASCII (letras, numeros, simbolos)...");
                }

                entradaValida = true;
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
                tec.nextLine();
            }
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

    private boolean entradaTextoValida(String texto) {
        return PATRON_TEXTO.matcher(texto).matches();
    }
    
    private boolean contieneEspacios(String texto) {
        
        if (this.entradaTextoValida(texto)) {
            return false;
        }
        
        for (char c: texto.toCharArray()) {
            if (c == ' ') {
                return true;
            }
        }
        
        return false;
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

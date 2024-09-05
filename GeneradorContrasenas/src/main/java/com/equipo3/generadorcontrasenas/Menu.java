/*
 * Menu.java
 */
package com.equipo3.generadorcontrasenas;

import java.util.Scanner;

/**
 * Clase que despliega el menu de consola y maneja la selección de opciones del
 * usuario
 *
 * @author Equipo 3
 */
public class Menu {

    IGeneradorContrasenas generador;
    IEvaluadorContrasenas evaluador;
    Scanner tec = new Scanner(System.in);

    public Menu() {
        generador = new GeneradorContrasenas();
        evaluador = new EvaluadorContrasenas();
    }

    /**
     * Muestra el menu, recibe la opcion selecionada y ejecuta el método
     * correspondiente
     */
    public void desplegarMenu() {
        boolean ejecutar = true;

        do {
            //Despliega el menu
            System.out.println("Bienvenido al generador de contraseñas, "
                    + "seleccione la operación que desea realizar");
            System.out.println("1. Generar Contraseña");
            System.out.println("2. Evaluar Contraseña");
            System.out.println("3. Mostrar Contrasenas Guardadas");
            System.out.println("0.Salir");

            int opcion = tec.nextInt();

            //Ejecuta la opcion solicitada
            switch (opcion) {
                case 1 ->
                    generarContraseña();
                case 2 ->
                    evaluarContrasena();
                case 3 ->
                    evaluarContrasena();
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
    private void generarContraseña() {
        System.out.println("Ingrese la longitud que desea para su contraseña /n"
                + "longitud minima: 8");
        int longitud = tec.nextInt();

        String contrasena = generador.generarContrasena(longitud);
        System.out.println("Su nueva contraseña segura es " + contrasena);
        regresar();
    }

    /**
     * Ejecuta la evaluación de una contraseña existente ingresada por el
     * usuario
     */
    private void evaluarContrasena() {
        System.out.println("Ingrese la contraseña que desea evaluar");
        String contrasena = tec.next();

        String nivelSeguridad = evaluador.verificarSeguridad(contrasena).toString();
        System.out.println("Su contraseña tiene un nivel de seguridad "
                + nivelSeguridad);
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

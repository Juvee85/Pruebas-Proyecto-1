package com.equipo3.generadorcontrasenas;

import java.util.Iterator;

/**
 *
 * @author Equipo3
 */
public class Main {
    
    public static final String PATRON_CONTRASENAS = "^[a-zA-Z0-9?_=\\-$%&!]+$";
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.desplegarMenu();
    }
}
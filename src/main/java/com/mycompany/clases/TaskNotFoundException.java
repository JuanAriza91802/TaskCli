/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clases;

/**
 *
 * @author JAVIER ARIZA
 */
public class TaskNotFoundException extends Exception {

    public TaskNotFoundException(String message) {
        super(message);
    }

    // Constructor sin argumentos para casos en los que se quiera un mensaje por defecto
    public TaskNotFoundException() {
        super(Colores.ANSI_RED +"La tarea no fue encontrada."+Colores.ANSI_RED);
    }
}

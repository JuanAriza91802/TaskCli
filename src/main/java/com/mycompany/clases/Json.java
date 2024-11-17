/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clases;


import java.io.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author JAVIER ARIZA
 */
public class Json {
    
    private  static final String FILE_PATH = "Tasks.json";
    
    
    // metodos
    private static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Manejo correcto de fechas
        return objectMapper;
    }
    //Guardar lista de tareas en un json
    public static void saveTask(List <Task> tasks){
        ObjectMapper object = getObjectMapper();
        try {
            object.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), tasks);
            System.out.println("Tareas guardadas exitosamente en " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error al guardar las tareas: " + e.getMessage());
        }
    }
    // cargar Json
    public static List<Task> uploadTask(){
        ObjectMapper object = getObjectMapper();
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return object.readValue(file, new TypeReference <List <Task>>(){});
            }
            else{
                return new ArrayList<>();
            }
        } catch (Exception e) {
            System.err.println("Error al cargar las tareas: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
}

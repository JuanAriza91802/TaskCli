/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clases;

import java.util.*;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author JAVIER ARIZA
 */
public class Manager {

    private List<Task> tasks;

    public Manager() {
        tasks = new ArrayList<>();
    }

    public int size() {
        return tasks.size();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void update(int id, String description) throws TaskNotFoundException {
        int index = findTaskIndex(id);
        Task task = tasks.get(index);
        task.setDescription(description);
        task.setUpdateAt();
    }

    public void delete(int id) throws TaskNotFoundException {
        int index = findTaskIndex(id);
        tasks.remove(index);
    }

    public void mark(int id, String status) throws TaskNotFoundException {
        int index = findTaskIndex(id);
        tasks.get(index).setStatus(status);
        tasks.get(index).setUpdateAt();
    }

    public void list() {
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }

    public void listByStatus(String status) {
        tasks.stream()
                .filter(task -> task.getStatus().equals(status))
                .forEach(System.out::println);
    }

    public void save(String filePath) throws IOException {
        // Implement logic to save tasks to a file (e.g., JSON)
    }

    private int findTaskIndex(int id) throws TaskNotFoundException {
        int primero, centro, ultimo;
        primero = 0;
        ultimo = tasks.size() - 1;
        Task temp = tasks.get(primero);
        if (temp.getId() == id) {
            return primero;
        }

        temp = tasks.get(ultimo);
        if (temp.getId() == id) {
            return ultimo;
        }

        while (primero <= ultimo) {
            centro = (primero + ultimo) / 2;
            temp = tasks.get(centro);
            if (temp.getId() == id) {
                return centro;
            } else if (temp.getId() < id) {
                ultimo = centro - 1;
            } else if (temp.getId() > id) {
                primero = centro + 1;
            }
        }

        return -1;

//    int index = tasks.indexOf(new Task(id)); // Use Task with id for comparison
//    if (index == -1) {
//      throw new TaskNotFoundException(Colores.ANSI_RED +"Task with id " + id + " not found"+ Colores.ANSI_RED);
//    }
//    return index;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clases;

import java.util.*;
import java.io.IOException;

/**
 *
 * @author JAVIER ARIZA
 */
public class Manager {

    private List<Task> tasks;

    public Manager() {
        tasks = Json.uploadTask();

    }

    //metodos
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
    }

    public void delete(int id) throws TaskNotFoundException {
        int index = findTaskIndex(id);
        tasks.remove(index);
    }

    public void mark(int id, String status) throws TaskNotFoundException {
        int index = findTaskIndex(id);
        tasks.get(index).setStatus(status);
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
    int primero = 0;
    int ultimo = tasks.size() - 1;

    while (primero <= ultimo) {
        int centro = primero + (ultimo - primero) / 2; // Evita desbordamientos
        Task temp = tasks.get(centro);

        if (temp.getId() == id) {
            return centro; // Devuelve el índice si encuentra la tarea
        } else if (temp.getId() < id) {
            primero = centro + 1; // Busca en la mitad derecha
        } else {
            ultimo = centro - 1; // Busca en la mitad izquierda
        }
    }

    // Lanza la excepción si no encuentra el elemento
    throw new TaskNotFoundException("Task with ID " + id + " not found.");
}

    // getter and setter
    public List<Task> getTasks() {
        return this.tasks;
    }

}

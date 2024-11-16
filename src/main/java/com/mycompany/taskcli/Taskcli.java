/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.taskcli;

import com.mycompany.clases.*;
import java.util.*;

/**
 *
 * @author JAVIER ARIZA
 */
public class Taskcli {

    public static void main(String[] args) throws TaskNotFoundException {
        Scanner sc = new Scanner(System.in);
        Manager mn = new Manager();
        boolean running = true;

        while (running) {
            System.out.print("task-cli: ");
            String input = sc.nextLine().toLowerCase().trim();

            try {
                String[] parts = input.split(" ");
                String description;
                switch (parts[0]) {
                    case "add":
                        if (parts.length < 2) {
                            throw new IllegalArgumentException("El comando 'add' requiere una descripción para la tarea.");
                        }
                        description = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length));
                        mn.add(new Task(mn.size(), description, "to do"));
                        System.out.println(Colores.ANSI_GREEN + "!! Se agregó la nueva tarea" + Colores.ANSI_GREEN);
                        break;
                    case "delete":
                        mn.delete(Integer.parseInt(parts[1]));
                        System.out.println(Colores.ANSI_RED + "!! Se eliminó" + Colores.ANSI_RED);
                        break;
                    case "update":
                        description = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length));
                        mn.update(Integer.parseInt(parts[1]), description);
                        System.out.println(Colores.ANSI_GREEN + "!! se actualizo la tarea" + Colores.ANSI_GREEN);
                        break;
                    case "mark-in-progress":
                        mn.mark(Integer.parseInt(parts[1]), "in-progress");
                        System.out.println("!! se marco como :" + Colores.ANSI_YELLOW + "in-progress" + Colores.ANSI_YELLOW);
                        break;
                    case "mark-done":
                        mn.mark(Integer.parseInt(parts[1]), "done");
                        System.out.println("!! se marco como :" + Colores.ANSI_GREEN + "done" + Colores.ANSI_GREEN);
                        break;

                    case "list":
                        if (parts.length > 1) {
                            mn.listByStatus(parts[1]);
                        } else {
                            mn.list();
                        }
                        break;
                    case "exit":
                        System.out.println(Colores.ANSI_BLUE +"hasta pronto..."+ Colores.ANSI_BLUE);
                        running = false;
                        break;
                    default:
                        System.out.println(Colores.ANSI_RED + "Comando no reconocido" + Colores.ANSI_RED);
                }
            } catch (TaskNotFoundException e) {
                System.out.println(Colores.ANSI_RED + "Tarea no encontrada." + Colores.ANSI_RED);
            } catch (NumberFormatException e) {
                System.out.println(Colores.ANSI_RED + "El ID de la tarea debe ser un número." + Colores.ANSI_RED);
            } catch (IllegalArgumentException e) {
                System.out.println(Colores.ANSI_RED + e.getMessage());
            }
        }
    }
}

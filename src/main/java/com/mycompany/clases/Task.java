/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clases;

import java.time.LocalDateTime;

/**
 *
 * @author JAVIER ARIZA
 */
public class Task {
    private int id;
    private String description;
    private String status;
    private LocalDateTime createAt;
    private LocalDateTime UpdateAt;
    // contructores
    public Task(){}
    public Task(int id, String description, String status){
        this.id = id;
        this.description = description;
        this.status = status;
        this.createAt = LocalDateTime.now();
    }

    Task(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    //metodos
    
    //getter and setter
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description= description;
    }
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    public LocalDateTime getUpdateAt(){
        return this.UpdateAt;
    }
    public void setUpdateAt(){
        this.UpdateAt = LocalDateTime.now();
    }

    public LocalDateTime getcreateAt(){
        return this.createAt;
    }
    public void setCreateAt(){
        this.createAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Task{\n"+"* Id:"+ this.id+"\n"
                        +"- Descripcion: "+ this.description+"\n"
                        +"- Estado: "+ this.status+"\n"
                        +"- Fecha de creacion: "+ this.createAt+"\n"
                        +"- Fecha de Actualizacion: "+ this.UpdateAt+'}';
    }
    
    
    
}

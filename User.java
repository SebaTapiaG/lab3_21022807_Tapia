package org.example.lab3_21022807_Tapia;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    private String name;
    private boolean tipo;   //Si el tipo es verdadero es administrador, si es falso es normal

    private boolean conectado; //Si conectado es verdadero, el usuario esta conectado

    private List<String> historial;

    public User(String name){
        this.name = name;
        this.tipo = false;  //El usuario es normal por defecto
        this.conectado = false;  //El usuario esta desconectado por defecto
        this.historial=new ArrayList<String>();

    }

    public String getName() {
        return name;
    }

    public boolean getTipo(){
        return tipo;
    }

    public List<String> getHistorial() {
        return historial;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public boolean mismoUser(String nombre){
        if (this.name == nombre){
            return true;
        }else {
            return false;
        }
    }

    public boolean isConectado() {
        return conectado;
    }

    //----------------Metodos Admin------------

    public void addChatbotToSystem(){
        if(!this.tipo) return;     //Si el tipo es Falso no permite este metodo


    }

    public void addFlowToChatbot(){
        if(!this.tipo) return;      //Si el tipo es Falso no permite este metodo


    }

    public void addOptionToFlow(){
        if(!this.tipo) return;      //Si el tipo es Falso no permite este metodo


    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Verifica si es la misma instancia
        if (obj == null) return false;  // Verifica si las clases son diferentes

        User auxUsuario = (User) obj;  // Hace un cast a Option

        // Compara los códigos utilizando equals()
        return getName() == auxUsuario.getName();
    }

    @Override
    public String toString() {
            return this.name;
    }

}

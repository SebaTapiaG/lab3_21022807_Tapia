package org.example.lab3_21022807_Tapia;

public class User {
    private String name;
    private boolean tipo;   //Si el tipo es verdadero es administrador, si es falso es normal

    private boolean conectado; //Si conectado es verdadero, el usuario esta conectado

    public User(String name){
        this.name = name;
        this.tipo = false;  //El usuario es normal por defecto
        this.tipo = false;  //El usuario esta desconectado por defecto

    }

    public String getName() {
        return name;
    }

    public boolean getTipo(){
        return tipo;
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
        if( this.tipo && this.conectado ) {
            return this.name + " conectado (Administrador)";
        } else if (this.tipo) {
            return this.name + " desconectado (Administrador)";
        }
        else if(!this.tipo && this.conectado) {
            return this.name + " conectado (Normal)";
        }
        else{
            return this.name + " desconectado (Normal)";

        }
    }

}

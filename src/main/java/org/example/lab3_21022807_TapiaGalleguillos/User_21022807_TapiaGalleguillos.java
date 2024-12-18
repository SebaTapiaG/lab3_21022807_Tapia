package org.example.lab3_21022807_TapiaGalleguillos;

import java.util.ArrayList;
import java.util.List;

public class User_21022807_TapiaGalleguillos implements IUser_21022807_TapiaGalleguillos {
    private String name;
    private boolean tipo;   //Si el tipo es verdadero es administrador, si es falso es normal

    private boolean conectado; //Si conectado es verdadero, el usuario esta conectado

    private List<String> historial;

    /**
     *
     * @param name
     */
    public User_21022807_TapiaGalleguillos(String name){
        this.name = name;
        this.tipo = false;  //El usuario es normal por defecto
        this.conectado = false;  //El usuario esta desconectado por defecto
        this.historial=new ArrayList<String>();

    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public boolean getTipo(){
        return tipo;
    }

    /**
     *
     * @return
     */
    public List<String> getHistorial() {
        return historial;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @param conectado
     */
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    /**
     *
     * @param nombre
     * @return
     */
    public boolean mismoUser(String nombre){
        if (this.name.equals(nombre)){
            return true;
        }else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public boolean isConectado() {
        return conectado;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Verifica si es la misma instancia
        if (obj == null) return false;  // Verifica si las clases son diferentes

        User_21022807_TapiaGalleguillos auxUsuario = (User_21022807_TapiaGalleguillos) obj;  // Hace un cast a Option

        // Compara los códigos utilizando equals()
        return getName() == auxUsuario.getName();
    }

    @Override
    public String toString() {
            return this.name;
    }

}

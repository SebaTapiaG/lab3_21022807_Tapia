package org.example.lab3_21022807_TapiaGalleguillos;

import java.util.List;

public interface IUser {

    public String getName();

    public boolean getTipo();

    public List<String> getHistorial();

    public void setTipo(boolean tipo);

    public void setConectado(boolean conectado);

    public boolean mismoUser(String nombre);

    public boolean isConectado();
}

package org.example.lab3_21022807_Tapia;

import java.util.ArrayList;
import java.util.List;

public class Flow implements IFlow{
    private int id;
    private String nameMsg;
    private List<Option> option;

    public Flow(int id,String nameMsg, List<Option> option){
        this.id = id;
        this.nameMsg = nameMsg;
        this.option = new ArrayList<Option>();

        for(Option newOption : option){
            if(!this.option.contains(newOption)){
                this.option.add(newOption);
            }

        }

    }

    public int getId() {
        return id;
    }

    public String getNameMsg(){
        return nameMsg;
    }

    public List<Option> getOption() {
        return option;
    }

    public void setOption(List<Option> option) {
        this.option = option;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Verifica si es la misma instancia
        if (obj == null) return false;  // Verifica si las clases son diferentes

        Flow auxFlow = (Flow) obj;  // Hace un cast a Option

        // Compara los códigos utilizando equals()
        return getId() == auxFlow.getId();
    }


    public void flowAddOption(Option op){
        if (!getOption().contains(op)) {
            this.option.add(op);
            setOption(option);
        }else return;
    }

    public boolean mismoId(int id){
        if (this.id == id){
            return true;
        }else {
            return false;
        }
    }
    public List<String> verOptions(List<Option> options){
        List<String> opciones = new ArrayList<String>();
        for(Option option: options){
            opciones.add(option.toString());
        }
        return opciones;

    }



    @Override
    public String toString() {
        return String.format("%s %s",this.nameMsg,String.join("\n",verOptions(getOption())));


    }

    public String verFlow(){
        return String.format("ID Flow: %s, Nombre: %s, Opciones: %s",this.id,this.nameMsg,String.join("\n",verOptions(getOption())));
    }
}

package org.example.lab3_21022807_Tapia;

import java.util.ArrayList;
import java.util.List;

public class Flow {
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


    @Override
    public String toString() {
        return this.nameMsg + " " + String.join("\n", getOption().toString());
    }
}

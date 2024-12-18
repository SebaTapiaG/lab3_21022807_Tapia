package org.example.lab3_21022807_TapiaGalleguillos;

import java.util.ArrayList;
import java.util.List;

public class Flow_21022807_TapiaGalleguillos implements IFlow_21022807_TapiaGalleguillos {
    private int id;
    private String nameMsg;
    private List<Option_21022807_TapiaGalleguillos> option;

    /**
     *Constructor del objeto
     * @param id
     * @param nameMsg
     * @param option
     */
    public Flow_21022807_TapiaGalleguillos(int id, String nameMsg, List<Option_21022807_TapiaGalleguillos> option){
        this.id = id;
        this.nameMsg = nameMsg;
        this.option = new ArrayList<Option_21022807_TapiaGalleguillos>();

        for(Option_21022807_TapiaGalleguillos newOption : option){
            if(!this.option.contains(newOption)){
                this.option.add(newOption);
            }

        }

    }

    /**
     *Obtiene el id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *Obtiene el nameMSG
     * @return nameMSG
     */
    public String getNameMsg(){
        return nameMsg;
    }

    /**
     *Obtiene la lista de options
     * @return List</Option>
     */
    public List<Option_21022807_TapiaGalleguillos> getOption() {
        return option;
    }

    /**
     *Cambia el id
     * @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *Cambia el nameMSG
     * @param nameMsg nuevo nameMSG
     */
    public void setNameMsg(String nameMsg) {
        this.nameMsg = nameMsg;
    }

    /**
     * Verifica si 2 objetos son iguales
     * @param obj
     * @return boolean, si son iguales retorna true
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        Flow_21022807_TapiaGalleguillos auxFlow = (Flow_21022807_TapiaGalleguillos) obj;

        // Compara los ids utilizando equals()
        return getId() == auxFlow.getId();
    }

    /**
     *Agrega una option al Flow
     * @param op option a agregar
     */
    public void flowAddOption(Option_21022807_TapiaGalleguillos op){
        if (!getOption().contains(op)) {
            this.option.add(op);
        }else return;
    }

    /**
     *Verifica si un id es el mismo del objeto
     * @param id
     * @return boolean , true si es el mismo id
     */
    public boolean mismoId(int id){
        if (this.id == id){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Devuelve una lista de options en forma de String
     * @return List</String>
     */
    public List<String> verOptions(){
        List<String> opciones = new ArrayList<String>();
        for(Option_21022807_TapiaGalleguillos option: getOption()){
            opciones.add(option.toString());
        }
        return opciones;

    }

    /**
     *Busca una option del flow segun su code
     * @param code
     * @return option , Option encontrada
     */
    public Option_21022807_TapiaGalleguillos buscarOption(String code){
        for(Option_21022807_TapiaGalleguillos optionAux : getOption()){
            if (optionAux.mismoCode(code)){
                return optionAux;
            }
        }
        return null;
    }


    /**
     * Convirte en string al objeto
     * @return String objeto
     */
    @Override
    public String toString() {
        return String.format("%s %s",this.nameMsg,String.join("\n",verOptions()));


    }

    /**
     *Convierte el objeto a string con un formato determinado
     * @return String flow formateado
     */
    public String verFlow(){
        return String.format("ID Flow: %s, Nombre: %s, Opciones: %s",this.id,this.nameMsg,String.join("\n",verOptions()));
    }
}

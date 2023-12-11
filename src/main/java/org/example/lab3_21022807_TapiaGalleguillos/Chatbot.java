package org.example.lab3_21022807_TapiaGalleguillos;

import java.util.ArrayList;
import java.util.List;

public class Chatbot implements IChatbot{
    private int chatbotID ;
    private String name;
    private String welcomeMessage;
    private int startFlowId;

    private List<Flow> flows;

    /**
     *Constructo del objeto
     * @param chatbotID
     * @param name
     * @param welcomeMessage
     * @param startFlowId
     * @param flows
     */
    public Chatbot(int chatbotID, String name, String welcomeMessage, int startFlowId, List<Flow> flows){
        this.chatbotID= chatbotID;
        this.name=name;
        this.welcomeMessage=welcomeMessage;
        this.startFlowId=startFlowId;
        this.flows= new ArrayList<Flow>();

        for(Flow newFlow : flows) {
            if (!this.flows.contains(newFlow)) {
                this.flows.add(newFlow);
            }

        }
    }

    /**
     *Obtiene el chatbotID
     * @return chatbotID
     */
    public int getChatbotID() {
        return chatbotID;
    }

    /**
     *Obtiene el name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *Obtiene el welcomeMessage
     * @return welcomeMessage
     */
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    /**
     *Obtiene el startFlowID
     * @return startFlowID
     */
    public int getStartFlowId() {
        return startFlowId;
    }

    /**
     *Obtiene la lista de flows
     * @return List</Flow>
     */
    public List<Flow> getFlows() {
        return flows;
    }

    /**
     *Cambia el startFlowId
     * @param startFlowId nuevo startFlowId
     */
    public void setStartFlowId(int startFlowId) {
        this.startFlowId = startFlowId;
    }

    /**
     *Cambia el name
     * @param name nuevo name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Cambia el chatbotID
     * @param chatbotID nuevo chatbotID
     */
    public void setChatbotID(int chatbotID) {
        this.chatbotID = chatbotID;
    }

    /**
     *Cambia el welcomeMessage
     * @param welcomeMessage nuevo welcomeMessage
     */
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    /**
     * Obtiene el flow initial a partir del startFlowID
     * @return flow inicial
     */
    public Flow getInitialFlow() {
        Flow flowInitial = null;
        int id = getStartFlowId();
        for (Flow initialFlow : getFlows()) {
            if (initialFlow.mismoId(id)) {
                flowInitial = initialFlow;
                return flowInitial;
            }
        }
        return flowInitial;
    }

    /**
     * Verifica si 2 objetos son iguales
     * @param obj
     * @return boolean, si son iguales retorna true
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        Chatbot auxChatbot = (Chatbot) obj;

        // Compara los ids utilizando equals()
        return getChatbotID() == auxChatbot.getChatbotID();
    }

    /**
     *Verifica si un id es el mismo del objeto
     * @param id
     * @return boolean, true si es el mismo id
     */
    public boolean mismoID(int id){
        if (this.chatbotID == id){
            return true;
        }else {
            return false;
        }
    }

    /**
     *Agrega un flow al chatbot
     * @param fl , flow a agregar
     */
    public void chatbotAddFlow(Flow fl){
        if (!getFlows().contains(fl)) {
            this.flows.add(fl);
        }else return;

    }

    /**
     *Busca una flow del chatbot segun su id
     * @param id
     * @return flow encontrado
     */
    public Flow buscarFlow(int id){
        for(Flow flowAux : getFlows()){
            if (flowAux.mismoId(id)){
                return flowAux;
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
        return  String.format("%s %s",this.welcomeMessage,getInitialFlow());
    }

    /**
     *Convierte el objeto a string con un formato determinado
     * @return String chatbot formateado
     */
    public String verChatbot(){
        List<String> mostrar = new ArrayList<String>();
        for(Flow flow : getFlows()){
            mostrar.add(flow.verFlow());
        }
        return String.format("ID: %s, Nombre: %s, welcomeMessage %s, Flows: %s ",this.chatbotID,this.name,this.welcomeMessage,String.join("\n",mostrar));
    }
}




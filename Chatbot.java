package org.example.lab3_21022807_Tapia;

import java.util.ArrayList;
import java.util.List;

public class Chatbot implements IChatbot{
    private int chatbotID ;
    private String name;
    private String welcomeMessage;
    private int startFlowId;

    private List<Flow> flows;

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

    public int getChatbotID() {
        return chatbotID;
    }

    public String getName() {
        return name;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public int getStartFlowId() {
        return startFlowId;
    }

    public List<Flow> getFlows() {
        return flows;
    }


    public void setStartFlowId(int startFlowId) {
        this.startFlowId = startFlowId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChatbotID(int chatbotID) {
        this.chatbotID = chatbotID;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

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


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Verifica si es la misma instancia
        if (obj == null) return false;  // Verifica si las clases son diferentes

        Chatbot auxChatbot = (Chatbot) obj;  // Hace un cast a Option

        // Compara los códigos utilizando equals()
        return getChatbotID() == auxChatbot.getChatbotID();
    }

    public boolean mismoID(int id){
        if (this.chatbotID == id){
            return true;
        }else {
            return false;
        }
    }

    public void chatbotAddFlow(Flow fl){
        if (!getFlows().contains(fl)) {
            this.flows.add(fl);
        }else return;

    }

    public Flow buscarFlow(int id){
        for(Flow flowAux : getFlows()){
            if (flowAux.mismoId(id)){
                return flowAux;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return  String.format("%s %s",this.welcomeMessage,getInitialFlow());
    }

    public String verChatbot(){
        List<String> mostrar = new ArrayList<String>();
        for(Flow flow : getFlows()){
            mostrar.add(flow.verFlow());
        }
        return String.format("ID: %s, Nombre: %s, welcomeMessage %s, Flows: %s ",this.chatbotID,this.name,this.welcomeMessage,String.join("\n",mostrar));
    }
}




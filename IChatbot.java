package org.example.lab3_21022807_Tapia;

import java.util.List;

public interface IChatbot {

    public int getChatbotID();

    public String getName();

    public String getWelcomeMessage();

    public int getStartFlowId();

    public List<Flow> getFlows();

    public void setFlows(List<Flow> flows);

    public void setStartFlowId(int startFlowId);

    public Flow getInitialFlow();

    public boolean mismoID(int id);

    public void chatbotAddFlow(Flow fl);

    public Flow buscarFlow(int id);
}

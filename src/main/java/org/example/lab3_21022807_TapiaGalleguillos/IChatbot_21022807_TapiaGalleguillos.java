package org.example.lab3_21022807_TapiaGalleguillos;

import java.util.List;

public interface IChatbot_21022807_TapiaGalleguillos {

    public int getChatbotID();

    public String getName();

    public String getWelcomeMessage();

    public int getStartFlowId();

    public List<Flow_21022807_TapiaGalleguillos> getFlows();


    public void setStartFlowId(int startFlowId);

    public Flow_21022807_TapiaGalleguillos getInitialFlow();

    public boolean mismoID(int id);

    public void chatbotAddFlow(Flow_21022807_TapiaGalleguillos fl);

    public Flow_21022807_TapiaGalleguillos buscarFlow(int id);

    public String verChatbot();
}


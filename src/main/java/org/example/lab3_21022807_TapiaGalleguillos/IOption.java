package org.example.lab3_21022807_TapiaGalleguillos;

import java.util.List;

public interface IOption {

    public int getCode();


    public int getChatbotCodeLink();

    public int getInitialFlowCodeLink();

    public List<String> getKeyword();

    public boolean mismaKey(String message);

    public boolean mismoCode(String message);













}

package org.example.lab3_21022807_Tapia;

import java.util.List;

public class Option {
    private int code;
    private String message;
    private int ChatbotCodeLink;
    private int InitialFlowCodeLink;
    private List<String> Keyword;

    public Option(int code, String message, int ChatbotCodeLink, int InitialFlowCodeLink, List<String> Keyword) {
        this.code = code;
        this.message = message;
        this.ChatbotCodeLink = ChatbotCodeLink;
        this.InitialFlowCodeLink = InitialFlowCodeLink;
        this.Keyword = Keyword;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getChatbotCodeLink() {
        return ChatbotCodeLink;
    }

    public int getInitialFlowCodeLink() {
        return InitialFlowCodeLink;
    }

    public List<String> getKeyword() {
        return Keyword;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Verifica si es la misma instancia
        if (obj == null) return false;  // Verifica si las clases son diferentes

        Option auxOption = (Option) obj;  // Hace un cast a Option

        // Compara los códigos utilizando equals()
        return getCode() == auxOption.getCode();
    }

    public boolean mismaKey(String message){
        if (this.Keyword.contains(message)){
            return true;
        }else {
            return false;
        }
    }

    public boolean mismoCode(String message){
        int messageCode = Integer.parseInt(message);
        if (this.code == messageCode){
            return true;
        }else {
            return false;
        }
    }


    @Override
    public String toString() {
        return this.code + " " + this.message + " ";
    }


}



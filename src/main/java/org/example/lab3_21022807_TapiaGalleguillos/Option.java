package org.example.lab3_21022807_TapiaGalleguillos;

import java.util.List;

public class Option implements IOption{
    private int code;
    private String message;
    private int ChatbotCodeLink;
    private int InitialFlowCodeLink;
    private List<String> Keyword;

    /**
     * Contructor del objeto
     * @param code
     * @param message
     * @param ChatbotCodeLink
     * @param InitialFlowCodeLink
     * @param Keyword
     */
    public Option(int code, String message, int ChatbotCodeLink, int InitialFlowCodeLink, List<String> Keyword) {
        this.code = code;
        this.message = message;
        this.ChatbotCodeLink = ChatbotCodeLink;
        this.InitialFlowCodeLink = InitialFlowCodeLink;
        this.Keyword = Keyword;
    }

    /**
     *Obtiene el Code
     * @return  Code
     */
    public int getCode() {
        return code;
    }


    /**
     * Obtiene el chatbotCodeLink
     * @return chatbotCodeLink
     */
    public int getChatbotCodeLink() {
        return ChatbotCodeLink;
    }

    /**
     * Obtiene el initialFlowCodeLink
     * @return initialFlowCodeLink
     */
    public int getInitialFlowCodeLink() {
        return InitialFlowCodeLink;
    }

    /**
     * Obtiene la lista de Keywords
     * @return keywords
     */
    public List<String> getKeyword() {
        return Keyword;
    }

    /**
     * Cambia el code
     * @param code, nuevo code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Cambia el message
     * @param message, nuevo message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *Cambia el cahtbotCodeLink
     * @param chatbotCodeLink, nuevo chatbotCodeLink
     */
    public void setChatbotCodeLink(int chatbotCodeLink) {
        ChatbotCodeLink = chatbotCodeLink;
    }

    /**
     *Cambia el initialFlowCodeLink
     * @param initialFlowCodeLink, nuevo initialFlowCodeLink
     */
    public void setInitialFlowCodeLink(int initialFlowCodeLink) {
        InitialFlowCodeLink = initialFlowCodeLink;
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

        Option auxOption = (Option) obj;

        // Compara los codes de la option utilizando equals()
        return getCode() == auxOption.getCode();
    }

    /**
     * Verifica si una keyword pertenece al objeto
     * @param message, keyword a buscar
     * @return boolean, si la keyword contiene message retorna true
     */
    public boolean mismaKey(String message){
        if (this.Keyword.contains(message)){
            return true;
        }else {
            return false;
        }
    }

    /**
     *Verifica si un code es el mismo del objeto
     * @param message code a verificar
     * @return bool, retorna true si el code es el mismo
     */
    public boolean mismoCode(String message){
        int messageCode = Integer.parseInt(message);
        if (this.code == messageCode){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Convirte en string al objeto
     * @return String objeto
     */
    @Override
    public String toString() {
        return String.format("%d) %s",this.code,this.message);
    }




}



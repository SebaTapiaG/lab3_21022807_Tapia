package org.example.lab3_21022807_Tapia;




import java.util.ArrayList;

import java.util.List;


public class system {

    private String name;
    private int initialChatbotCodeLink;
    private List<Chatbot> chatbots;

    private List<User> users;

    private List<String> historial;

    public system(String name, int initialChatbotCodeLink, List<Chatbot> chatbots) {
        this.name = name;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.chatbots = new ArrayList<Chatbot>();
        this.users = new ArrayList<User>();
        this.historial = new ArrayList<String>();

        for (Chatbot newChatbot : chatbots) {
            if (!this.chatbots.contains(newChatbot)) {
                this.chatbots.add(newChatbot);
            }

        }
    }

    public String getName() {
        return name;
    }

    public int getInitialChatbotCodeLink() {
        return initialChatbotCodeLink;
    }

    public List<Chatbot> getChatbots() {
        return chatbots;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<String> getHistorial() {
        return historial;
    }

    public Chatbot getChatbotInitial(){
        Chatbot chatbotInitial = null;
        int id = getInitialChatbotCodeLink();
        for(Chatbot initialChat : getChatbots()){
            if (initialChat.mismoID(id)){
                chatbotInitial = initialChat;
                return chatbotInitial;
            }
        }
        return chatbotInitial;
    }

    public List<Option> getInitialOptions(){
      return getChatbotInitial().getInitialFlow().getOption();
    }


    public void setChatbots(List<Chatbot> chatbots) {
        this.chatbots = chatbots;
    }

    public void setInitialChatbotCodeLink(int initialChatbotCodeLink) {
        this.initialChatbotCodeLink = initialChatbotCodeLink;
    }

    public void actualizarHistorial(String message){
        String newHistorial = toString();
        this.historial.add(message + "\t" + newHistorial);

    }

    public void systemAddChatbot(Chatbot cb) {
        if (!getChatbots().contains(cb)) {
            this.chatbots.add(cb);
            setChatbots(chatbots);
        } else {
            this.chatbots.remove(cb);
            this.chatbots.add(cb);
        }
    }

    public void systemAddUser(User newUser) {
        if (!getUsers().contains(newUser)) {
            this.users.add(newUser);
        }
    }

    public void systemLogin(String user) {
        //Hay un usuario conectado?
        for(User conectadoUser : getUsers()) {
            if(conectadoUser.isConectado()){
                return;
        }
        }
        //Buscamos el usuario
        User userConect = null;
        for(User buscarUser : getUsers()){
            if(buscarUser.mismoUser(user)){
                userConect = buscarUser;
                break;
            }
        }
        if(userConect != null){
            userConect.setConectado(true);

            getUsers().remove(userConect);
            getUsers().add(userConect);

        }
        else return;

    }

    public void systemLogout(){
        User userConect = null;
        for(User conectadoUser : getUsers()) {
            if(conectadoUser.isConectado()){
                userConect = conectadoUser;
                break;
            }
        }
        if(userConect!=null){
            userConect.setConectado(false);

            getUsers().remove(userConect);
            getUsers().add(userConect);
        }else return;
    }

    public Option optionEscogida(String message){
        Option optionElegida = null;
        for(Option buscarOption : getInitialOptions()) {
            if (buscarOption.mismaKey(message)) {
                optionElegida = buscarOption;
                return optionElegida;
            }
            if (buscarOption.mismoCode(message)) {
                optionElegida = buscarOption;
                return optionElegida;
            }
        }
        return optionElegida;
    }

    public void systemTalk(String message){
        if(getHistorial().isEmpty()){
            actualizarHistorial(message);
        }
        else {
            //Actualiza los links
            Option optionElegida = optionEscogida(message);
            int initialIdFl = optionElegida.getInitialFlowCodeLink();
            int initialIdCb = optionElegida.getChatbotCodeLink();
            setInitialChatbotCodeLink(initialIdCb);
            Chatbot chatbotInitial = getChatbotInitial();
            chatbotInitial.setStartFlowId(initialIdFl);
            systemAddChatbot(chatbotInitial);
            actualizarHistorial(message);
        }
    }

    @Override
    public String toString() {
        return  "- " + getChatbots();
    }

    public String mostrarHistorial(){
        return String.join("\t ",getHistorial());
    }

}
package org.example.lab3_21022807_Tapia;




import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;


public class system implements ISystem {

    private String name;
    private int initialChatbotCodeLink;
    private List<Chatbot> chatbots;

    private List<User> users;


    public system(String name, int initialChatbotCodeLink, List<Chatbot> chatbots) {
        this.name = name;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.chatbots = new ArrayList<Chatbot>();
        this.users = new ArrayList<User>();

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


    public User getUserConect(){
        for(User conectadoUser : getUsers()) {
            if(conectadoUser.isConectado()){
                return conectadoUser;
            }
        }
        return null;

    }

    public boolean inicioSesion(){
        if(getUserConect() != null){  //Si hay un usuario conectado devuelve True
            return true;
        }
        return false;
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

    public void actualizarHistorial(User user,String message){
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = fechaActual.format(formato);
        String newHistorial = toString();
        user.getHistorial().add(fechaFormateada + "- " + user + ": " + message + "\t" + newHistorial);

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
        if(!inicioSesion()) {   //No hay ningun usuario conectado

            //Buscamos el usuario
            User userConect = null;
            for (User buscarUser : getUsers()) {
                if (buscarUser.mismoUser(user)) {
                    userConect = buscarUser;
                    break;
                }
            }
            if (userConect != null) {
                userConect.setConectado(true);

            }
        }
        else return;

    }

    public void systemLogout(){
        User userConect = getUserConect();
        if(userConect!=null){
            userConect.setConectado(false);
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
        if(!inicioSesion()){
            return;
        }

        User userConect = getUserConect();

        if(userConect.getHistorial().isEmpty()){
            actualizarHistorial(userConect,message);
        }
        else {
            //Actualiza los links
            Option optionElegida = optionEscogida(message);
            if(optionElegida == null){  //No existe la opcion
                return;
            }else {
                int initialIdFl = optionElegida.getInitialFlowCodeLink();
                int initialIdCb = optionElegida.getChatbotCodeLink();
                setInitialChatbotCodeLink(initialIdCb);
                Chatbot chatbotInitial = getChatbotInitial();
                chatbotInitial.setStartFlowId(initialIdFl);
                actualizarHistorial(userConect, message);
            }
        }

    }

    @Override
    public String toString() {
        return  String.format("%s", getChatbotInitial());
    }

    public String systemSynthesis(String user){

        //Buscamos el usuario
        User userSearch = null;
        for (User buscarUser : getUsers()) {
            if (buscarUser.mismoUser(user)) {
                userSearch = buscarUser;
                break;
            }
        }
        if(userSearch.getHistorial().isEmpty()){
            return("El usuario no tiene historial");
        }

        return String.join("\n ",userSearch.getHistorial());
    }

    public void systemSymulate(int maxInteractions, int seed){
        String semilla = String.valueOf(seed);
        int contador = 0;
        systemTalk("Simulacion");
        while(contador < maxInteractions){
            systemTalk(String.valueOf(semilla.charAt(0)));
            systemTalk(String.valueOf(semilla.charAt(1)));
            systemTalk(String.valueOf(semilla.charAt(2)));
            systemTalk(String.valueOf(semilla.charAt(3)));
            contador++;
        }
    }

    public String mostrarChatbots(){
        List<String> mostrar = new ArrayList<String>();
        for(Chatbot chatbot : getChatbots()){
            mostrar.add(chatbot.verChatbot());
        }
        return String.join("\n",mostrar);
    }

}
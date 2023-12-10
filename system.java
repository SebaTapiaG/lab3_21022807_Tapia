package org.example.lab3_21022807_Tapia;




import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;


public class system implements ISystem {

    private String name;
    private int initialChatbotCodeLink;
    private List<Chatbot> chatbots;

    private List<User> users;

    /**
     * Constructor del objeto
     * @param name
     * @param initialChatbotCodeLink
     * @param chatbots
     */
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

    /**
     * Obtiene el name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el initialChatbotCodeLink
     * @return initialChatbotCodeLink
     */
    public int getInitialChatbotCodeLink() {
        return initialChatbotCodeLink;
    }

    /**
     * Obtiene la lista de chatbots
     * @return List</Chatbot>
     */
    public List<Chatbot> getChatbots() {
        return chatbots;
    }

    /**
     * Obtiene la lista de users
     * @return List</User>
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Devuelve el usuario conectado
     * @return User ,usuario conectado
     */
    public User getUserConect() {
        for (User conectadoUser : getUsers()) {
            if (conectadoUser.isConectado()) {
                return conectadoUser;
            }
        }
        return null;

    }

    /**
     * Verifica si hay un usuario conectado
     * @return boolean ,si hay un usuario conectado devuelve true
     */
    public boolean inicioSesion() {
        if (getUserConect() != null) {  //Si hay un usuario conectado devuelve True
            return true;
        }
        return false;
    }

    /**
     * Obtiene el chatbot inicial
     * @return Chatbot ,chatbot inicial
     */
    public Chatbot getChatbotInitial() {
        Chatbot chatbotInitial = null;
        int id = getInitialChatbotCodeLink();
        for (Chatbot initialChat : getChatbots()) {
            if (initialChat.mismoID(id)) {
                chatbotInitial = initialChat;
                return chatbotInitial;
            }
        }
        return chatbotInitial;
    }

    /**
     * Verifica si el system contiene un chatbot especifico
     * @param id del chatbot a buscar
     * @return boolean ,si existe el chatbot retorna true
     */
    public boolean existeChatbot(int id) {
        for (Chatbot existeChatbot : getChatbots()) {
            if (existeChatbot.mismoID(id)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Busca un chatbot especifico del system
     * @param id ,id del chatbot a buscar
     * @return Chatbot encontrado
     */
    public Chatbot buscarChatbot(int id) {
        for (Chatbot chatbotAux : getChatbots()) {
            if (chatbotAux.mismoID(id)) {
                return chatbotAux;
            }
        }
        return null;
    }

    /**
     * Obtiene las opciones iniciales
     * @return List</Option>
     */
    public List<Option> getInitialOptions() {
        return getChatbotInitial().getInitialFlow().getOption();
    }


    /**
     * Cambia el initialChatbotCodeLink
     * @param initialChatbotCodeLink ,nuevo initialChatbotCodeLink
     */
    public void setInitialChatbotCodeLink(int initialChatbotCodeLink) {
        this.initialChatbotCodeLink = initialChatbotCodeLink;
    }

    /**
     * Actualiza el historial del user
     * @param user
     * @param message
     */
    public void actualizarHistorial(User user, String message) {
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = fechaActual.format(formato);
        String newHistorial = toString();
        user.getHistorial().add(fechaFormateada + "- " + user + ": " + message + "\t" + newHistorial);

    }

    /**
     * Agrega un chatbot al system
     * @param cb ,chatbot a agregar
     */
    public void systemAddChatbot(Chatbot cb) {
        if (!getChatbots().contains(cb)) {
            this.chatbots.add(cb);
        } else {
            this.chatbots.remove(cb);
            this.chatbots.add(cb);
        }
    }

    /**
     * Agrega un user al system
     * @param newUser ,User a agregar
     */
    public void systemAddUser(User newUser) {
        if (!getUsers().contains(newUser)) {
            this.users.add(newUser);
        }
    }

    /**
     * Un usuario inicia sesion
     * @param user
     */
    public void systemLogin(String user) {
        //Hay un usuario conectado?
        if (!inicioSesion()) {   //No hay ningun usuario conectado

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
        } else return;

    }

    /**
     * Cierra sesion
     */
    public void systemLogout() {
        User userConect = getUserConect();
        if (userConect != null) {
            userConect.setConectado(false);
        } else return;
    }

    /**
     * Busca una option del system segun su keyword o code
     * @param message ,Option elegida
     * @return
     */
    public Option optionEscogida(String message) {
        Option optionElegida = null;
        for (Option buscarOption : getInitialOptions()) {
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

    /**
     * Interactua con el chatbot, eligiendo una option segun su keyword o code
     * @param message
     */
    public void systemTalk(String message) {
        if (!inicioSesion()) {
            return;
        }

        User userConect = getUserConect();

        if (userConect.getHistorial().isEmpty()) {
            actualizarHistorial(userConect, message);
        } else {
            //Actualiza los links
            Option optionElegida = optionEscogida(message);
            if (optionElegida == null) {  //No existe la option
                return;
            }
            int initialIdFl = optionElegida.getInitialFlowCodeLink();
            int initialIdCb = optionElegida.getChatbotCodeLink();
            if (!existeChatbot(initialIdCb)) {  //No existe el Chatbot
                return;
            }
            setInitialChatbotCodeLink(initialIdCb);
            Chatbot chatbotInitial = getChatbotInitial();
            chatbotInitial.setStartFlowId(initialIdFl);
            actualizarHistorial(userConect, message);
        }
    }

    /**
     * Convirte en string al objeto
     * @return String objeto
     */
    @Override
    public String toString() {
        return String.format("%s", getChatbotInitial());
    }

    /**
     * Devuelve el historial de un user
     * @param user
     * @return String historial del user
     */
    public String systemSynthesis(String user) {

        //Buscamos el usuario
        User userSearch = null;
        for (User buscarUser : getUsers()) {
            if (buscarUser.mismoUser(user)) {
                userSearch = buscarUser;
                break;
            }
        }
        if (userSearch.getHistorial().isEmpty()) {
            return ("El usuario no tiene historial");
        }

        return String.join("\n ", userSearch.getHistorial());
    }

    /**
     * Simula una interaccion con el chatbot
     * @param maxInteractions
     * @param seed
     */
    public void systemSymulate(int maxInteractions, int seed) {
        Random random = new Random(seed);
        // Generar el numero aleatorio
        int randomNumber = Math.abs(random.nextInt());
        String semilla = String.valueOf(randomNumber);
        int contador = 0;
        systemTalk("Simulacion");
        while (contador < maxInteractions) {
            int index = 0;
            while (index < semilla.length()) {
                systemTalk(String.valueOf(semilla.charAt(index)));
                index++;
            }
            contador++;
        }
    }

    /**
     * Muestra todos los chatbots del system
     * @return String formado por todos los chatbots
     */
    public String mostrarChatbots() {
        List<String> mostrar = new ArrayList<String>();
        for (Chatbot chatbot : getChatbots()) {
            mostrar.add(chatbot.verChatbot());
        }
        return String.join("\n", mostrar);
    }


}


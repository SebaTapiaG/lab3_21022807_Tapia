package org.example.lab3_21022807_Tapia;

import java.util.List;

public interface ISystem {
    public String getName();

    public int getInitialChatbotCodeLink();

    public List<Chatbot> getChatbots();

    public List<User> getUsers();


    public Chatbot getChatbotInitial();

    public List<Option> getInitialOptions();
    public User getUserConect();

    public boolean inicioSesion();
    

    public void setInitialChatbotCodeLink(int initialChatbotCodeLink);

    public void actualizarHistorial(User user,String message);

    public void systemAddChatbot(Chatbot cb);

    public void systemAddUser(User newUser);

    public void systemLogin(String user);

    public void systemLogout();

    public Option optionEscogida(String message);

    public void systemTalk(String message);

    public String systemSynthesis(String user);

    public String mostrarChatbots();

    public void systemSymulate(int maxInteractions, int seed);

    public boolean existeChatbot(int id);

    public String mostrarSystems(List<system> sistemas);


}

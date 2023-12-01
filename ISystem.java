package org.example.lab3_21022807_Tapia;

import java.time.LocalDateTime;
import java.util.List;

public interface ISystem {
    public String getName();

    public int getInitialChatbotCodeLink();

    public List<Chatbot> getChatbots();

    public List<User> getUsers();

    public List<String> getHistorial();

    public Chatbot getChatbotInitial();

    public List<Option> getInitialOptions();
    public User getUserConect();

    public boolean inicioSesion();

    public void setChatbots(List<Chatbot> chatbots);

    public void setInitialChatbotCodeLink(int initialChatbotCodeLink);

    public void actualizarHistorial(String message);

    public void systemAddChatbot(Chatbot cb);

    public void systemAddUser(User newUser);

    public void systemLogin(String user);

    public void systemLogout();

    public Option optionEscogida(String message);

    public void systemTalk(String message);

    public String mostrarHistorial();


}
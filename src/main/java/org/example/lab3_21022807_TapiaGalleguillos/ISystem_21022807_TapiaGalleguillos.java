package org.example.lab3_21022807_TapiaGalleguillos;

import java.util.List;

public interface ISystem_21022807_TapiaGalleguillos {
    public String getName();

    public int getInitialChatbotCodeLink();

    public List<Chatbot_21022807_TapiaGalleguillos> getChatbots();

    public List<User_21022807_TapiaGalleguillos> getUsers();


    public Chatbot_21022807_TapiaGalleguillos getChatbotInitial();

    public List<Option_21022807_TapiaGalleguillos> getInitialOptions();
    public User_21022807_TapiaGalleguillos getUserConect();

    public boolean inicioSesion();
    

    public void setInitialChatbotCodeLink(int initialChatbotCodeLink);

    public void actualizarHistorial(User_21022807_TapiaGalleguillos user, String message);

    public void systemAddChatbot(Chatbot_21022807_TapiaGalleguillos cb);

    public void systemAddUser(User_21022807_TapiaGalleguillos newUser);

    public void systemLogin(String user);

    public void systemLogout();

    public Option_21022807_TapiaGalleguillos optionEscogida(String message);

    public void systemTalk(String message);

    public String systemSynthesis(String user);

    public String mostrarChatbots();

    public void systemSymulate(int maxInteractions, int seed);

    public boolean existeChatbot(int id);


}

package org.example.lab3_21022807_TapiaGalleguillos;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //Creamos la lista de Keywords
        List<String> urbano = Arrays.asList("urbano", "latino", "urbano latino");
        List<String> rock = Arrays.asList("rock", "rock and roll");


        //Creamos la option del flow 1
        Option_21022807_TapiaGalleguillos op1 = new Option_21022807_TapiaGalleguillos(1, "Urbano latino", 1, 1, urbano);
        Option_21022807_TapiaGalleguillos op2 = new Option_21022807_TapiaGalleguillos(2, "Rock", 2, 1, rock);

        List<Option_21022807_TapiaGalleguillos> optionsFl1 = Arrays.asList(op1, op2, op1);
        //Creamos el flow
        Flow_21022807_TapiaGalleguillos flow1 = new Flow_21022807_TapiaGalleguillos(1, "¿Que genero quieres escuchar? \n", optionsFl1);

        List<Flow_21022807_TapiaGalleguillos> flowsCb1 = Arrays.asList(flow1);
        //Chatbot 1
        Chatbot_21022807_TapiaGalleguillos cb1 = new Chatbot_21022807_TapiaGalleguillos(0, "Genero musical", "Bienvenido \n", 1, flowsCb1);

        //Creamos la option del flow 2
        List<String> easyKid = Arrays.asList("easy", "easykid", "lil xayan");
        List<String> voodoo = Arrays.asList("kid voodoo", "voodoo", "satiro");
        List<String> cister = Arrays.asList("young cister", "cister", "youngcis");
        List<String> otroGen = Arrays.asList("volver", "otro", "cambiar");

        Option_21022807_TapiaGalleguillos op3 = new Option_21022807_TapiaGalleguillos(1, "Easykid", 1, 2, easyKid);
        Option_21022807_TapiaGalleguillos op4 = new Option_21022807_TapiaGalleguillos(2, "Kid Voodoo", 1, 3, voodoo);
        Option_21022807_TapiaGalleguillos op5 = new Option_21022807_TapiaGalleguillos(3, "Young Cister", 1, 4, cister);
        Option_21022807_TapiaGalleguillos op6 = new Option_21022807_TapiaGalleguillos(4, "Otro genero", 0, 1, otroGen);

        List<Option_21022807_TapiaGalleguillos> optionsFl2 = Arrays.asList(op3, op4, op5, op4);  //Solo agrega una instancia de op4

        Flow_21022807_TapiaGalleguillos flow2 = new Flow_21022807_TapiaGalleguillos(1, "¿Que artista quieres escuchar? \n", optionsFl2);

        flow2.flowAddOption(op6);   //Agregamos la op6

        //Creamos la option del flow 3

        List<String> pichea = Arrays.asList("pichea", "pa que pichea");
        List<String> pienso = Arrays.asList("siempre pienso en ti", "pienso");
        List<String> dkera = Arrays.asList("dkera", "darkera", "era");


        Option_21022807_TapiaGalleguillos op7 = new Option_21022807_TapiaGalleguillos(1, "Pa que pichea", 0, 1, pichea);
        Option_21022807_TapiaGalleguillos op8 = new Option_21022807_TapiaGalleguillos(2, "Siempre pienso en ti", 0, 1, pienso);
        Option_21022807_TapiaGalleguillos op9 = new Option_21022807_TapiaGalleguillos(3, "Darkera", 0, 1, dkera);

        List<Option_21022807_TapiaGalleguillos> optionsFl3 = Arrays.asList(op7, op8, op9);

        Flow_21022807_TapiaGalleguillos flow3 = new Flow_21022807_TapiaGalleguillos(2, "¿Que cancion quieres escuchar? \n", optionsFl3);

        //Creamos la option del flow 4
        List<String> mal = Arrays.asList("mal", "mal mal mal");
        List<String> fashion = Arrays.asList("fashion girl", "fashion");
        List<String> texteando = Arrays.asList("texteandome", "tas text");


        Option_21022807_TapiaGalleguillos op10 = new Option_21022807_TapiaGalleguillos(1, "Mal mal mal", 0, 1, mal);
        Option_21022807_TapiaGalleguillos op11 = new Option_21022807_TapiaGalleguillos(2, "Fashion girl", 0, 1, fashion);
        Option_21022807_TapiaGalleguillos op12 = new Option_21022807_TapiaGalleguillos(3, "Tas texteandome", 0, 1, texteando);


        List<Option_21022807_TapiaGalleguillos> optionsFl4 = Arrays.asList(op10, op11, op12);

        Flow_21022807_TapiaGalleguillos flow4 = new Flow_21022807_TapiaGalleguillos(3, "¿Que cancion quieres escuchar? \n", optionsFl4);

        //Creamos la option del flow 5
        List<String> casi = Arrays.asList("casi amor de verano", "casi");
        List<String> terapia = Arrays.asList("terapia", "la terapia");
        List<String> flores = Arrays.asList("flores", "debi llevarte flores");


        Option_21022807_TapiaGalleguillos op13 = new Option_21022807_TapiaGalleguillos(1, "Casi amor de verano", 0, 1, casi);
        Option_21022807_TapiaGalleguillos op14 = new Option_21022807_TapiaGalleguillos(2, "La terapia", 0, 1, terapia);
        Option_21022807_TapiaGalleguillos op15 = new Option_21022807_TapiaGalleguillos(3, "Debi llevarte flores", 0, 1, flores);


        List<Option_21022807_TapiaGalleguillos> optionsFl5 = Arrays.asList(op13, op14, op15);

        Flow_21022807_TapiaGalleguillos flow5 = new Flow_21022807_TapiaGalleguillos(4, "¿Que cancion quieres escuchar? \n", optionsFl5);

        List<Flow_21022807_TapiaGalleguillos> flowsCb2 = Arrays.asList(flow2, flow3, flow4);


        Chatbot_21022807_TapiaGalleguillos cb2 = new Chatbot_21022807_TapiaGalleguillos(1, "Urbano Latino", "Bienvenido \n", 0, flowsCb2);

        cb2.chatbotAddFlow(flow5);

        List<Chatbot_21022807_TapiaGalleguillos> chatbots = Arrays.asList(cb1, cb2);


        system_21022807_TapiaGalleguillos s1 = new system_21022807_TapiaGalleguillos("Sistema Chatbots Musica", 0, chatbots);

        User_21022807_TapiaGalleguillos user1 = new User_21022807_TapiaGalleguillos("Cesar");

        User_21022807_TapiaGalleguillos user2 = new User_21022807_TapiaGalleguillos("Mauro");

        s1.systemAddChatbot(cb2);

        s1.systemAddUser(user1);
        s1.systemAddUser(user2);

        s1.systemLogin("Mauro");

        s1.systemLogin("Cesar");


        s1.systemLogout();

        s1.systemLogin("Cesar");

        user1.setTipo(true);

        s1.systemTalk("Hola");

        s1.systemTalk("1");

        s1.systemTalk("2");

        s1.systemTalk("3");


        s1.systemLogout();


//-----------------Menu------------------------//
        Menu_21022807_TapiaGalleguillos menu = new Menu_21022807_TapiaGalleguillos();
        menu.registroMenu(s1);

    }






}








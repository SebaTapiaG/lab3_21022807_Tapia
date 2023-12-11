package org.example.lab3_21022807_TapiaGalleguillos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu_21022807_TapiaGalleguillos {

    /**
     * Menu de inicio y registro
     * @param sistema
     */
    public static void registroMenu(system_21022807_TapiaGalleguillos sistema){
        Scanner scanner = new Scanner(System.in);
        String entrada;

        do {

            System.out.println("1. Login de usuario \n");
            System.out.println("2. Registro de usuario \n");
            System.out.println("3. Salir");
            System.out.println("\nIngresa tu opcion: ");
            entrada=scanner.nextLine();

            switch (entrada){

                case "1":
                    System.out.println("Ingrese su nombre de usuario");
                    String nombreUsuario = scanner.next();
                    if(!sistema.existeUser(nombreUsuario)){
                        System.out.println("El usuario no existe");
                        break;
                    }
                    sistema.systemLogin(nombreUsuario);
                    if(!sistema.getUserConect().getTipo()) {   //El usuario es normal?
                        normalMenu(sistema, nombreUsuario);
                    }
                    adminMenu(sistema,nombreUsuario);
                    break;

                case "2":
                    userRegister(sistema);
                    break;

                case "3":
                    System.out.println("Gracias!, que te vaya bien!");
                    sistema.systemLogout();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!entrada.equals("3"));
        scanner.close();
    }

    /**
     * Menu para registrarse
     * @param sistema
     */
    public static void userRegister(system_21022807_TapiaGalleguillos sistema) {

        Scanner scanner = new Scanner(System.in);
        String entrada;

        do {
            System.out.println("1. Registrar usuario normal \n");
            System.out.println("2. Registrar usuario administrador \n");
            System.out.println("3. Volver");
            entrada = scanner.nextLine();

            switch (entrada) {

                case "1":
                    System.out.println("Ingrese su nombre de usuario: \n");
                    String nombreUsuario = scanner.next();
                    User_21022807_TapiaGalleguillos newUser = new User_21022807_TapiaGalleguillos(nombreUsuario);
                    sistema.systemAddUser(newUser);
                    sistema.systemLogin(nombreUsuario);      //Inicia sesion automaticamente
                    normalMenu(sistema,nombreUsuario);
                    break;

                case "2":
                    System.out.println("Ingrese su nombre de usuario: \n");
                    String nombreAdmin = scanner.next();
                    User_21022807_TapiaGalleguillos newAdmin = new User_21022807_TapiaGalleguillos(nombreAdmin);
                    newAdmin.setTipo(true);
                    sistema.systemAddUser(newAdmin);
                    sistema.systemLogin(nombreAdmin);   //Inicia sesion automaticamente
                    adminMenu(sistema,nombreAdmin);
                    break;

                case "3":
                    registroMenu(sistema);
                    break;


            }

        } while (!entrada.equals("3"));

        scanner.close();
    }

    /**
     * Menu del admin
      * @param sistema
     * @param nombreUsuario
     */
    public static void adminMenu(system_21022807_TapiaGalleguillos sistema, String nombreUsuario){
        Scanner scanner = new Scanner(System.in);
        String entrada;

        do {

            System.out.println("1. Crear un Chatbot \n");
            System.out.println("2. Modificar un Chatbot \n");
            System.out.println("3. Ejecutar un Chatbot \n");
            System.out.println("4. Visualizar todos los Chatbots existentes \n");
            System.out.println("5. Ejecutar una simulacion del sistema de Chatbot \n");
            System.out.println("6. Ver sintesis \n");
            System.out.println("7. Volver");
            System.out.println("\nIngresa tu opcion: ");
            entrada = scanner.nextLine();

            switch (entrada){

                case "1":
                    System.out.println("Ingresa el id del Chatbot: \n");
                    int id = scanner.nextInt();
                    System.out.println("Ingresa el nombre del Chatbot: \n");
                    String nombre = scanner.next();
                    System.out.println("Ingresa el welcome message del Chatbot: \n");
                    String welcome = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Ingresa el startFlowID del Chatbot: \n");
                    int startFlow = scanner.nextInt();
                    List<Flow_21022807_TapiaGalleguillos> flowsVacio = new ArrayList<Flow_21022807_TapiaGalleguillos>();
                    Chatbot_21022807_TapiaGalleguillos cbNuevo = new Chatbot_21022807_TapiaGalleguillos(id,nombre,welcome,startFlow,flowsVacio);
                    sistema.systemAddChatbot(cbNuevo);
                    break;

                case "2":
                    System.out.println(sistema.mostrarChatbots());
                    System.out.println("Elige el chatbot a modificar segun su id\n");
                    int idCb = scanner.nextInt();
                    Chatbot_21022807_TapiaGalleguillos chatbotBuscado = sistema.buscarChatbot(idCb);
                    modificarChat(sistema,nombreUsuario,chatbotBuscado);
                    break;

                case "3":
                    String opcion;
                    if(sistema.getUserConect().getHistorial().isEmpty()) {
                        System.out.println("Saluda al Chatbot :D ");
                        opcion = scanner.next();

                    }
                    else {
                        System.out.println(sistema);
                        opcion = scanner.next();
                    }
                    do {
                        sistema.systemTalk(opcion);
                        System.out.println(sistema);
                        opcion = scanner.next();
                        System.out.println("Ingresa tu opcion o Keyword (o 10 para salir) \n");
                    }while(!opcion.equals("10"));

                    adminMenu(sistema,nombreUsuario);

                    break;

                case "4":
                    System.out.println(sistema.mostrarChatbots() + "\n");
                    break;

                case "5":
                    System.out.println("Ingresa tu semilla: \n");
                    int seed = scanner.nextInt();
                    System.out.println("Ingresa el maximo de iteraciones: \n");
                    int i = scanner.nextInt();
                    sistema.systemSymulate(i,seed);
                    break;

                case "6":
                    String synthesis = sistema.systemSynthesis(nombreUsuario);
                    System.out.println(synthesis);
                    break;

                case "7":
                    sistema.systemLogout();
                    registroMenu(sistema);
                    break;

            }

        } while (!entrada.equalsIgnoreCase("7"));

        scanner.close();

    }

    /**
     * Menu de usuario normal
     * @param sistema
     * @param nombreUsuario
     */
    public static void normalMenu(system_21022807_TapiaGalleguillos sistema, String nombreUsuario){

        Scanner scanner = new Scanner(System.in);
        String entrada;

        do {

            System.out.println("1. Interactuar con el Chatbot \n");
            System.out.println("2. Ver sintesis \n");
            System.out.println("3. Simular dialogo entre dos Chatbots \n");
            System.out.println("4. Volver \n");
            System.out.println("\n Ingresa tu opcion: ");
            entrada= scanner.nextLine();

            switch (entrada){

                case "1":
                    String opcion;
                    if(sistema.getUserConect().getHistorial().isEmpty()) {
                        System.out.println("Saluda al Chatbot :D ");
                        opcion = scanner.next();
                    }
                    else {
                        System.out.println(sistema);
                        opcion = scanner.next();
                    }
                    do {
                        sistema.systemTalk(opcion);
                        System.out.println(sistema);
                        opcion = scanner.next();
                        System.out.println("Ingresa tu opcion o Keyword (o 10 para salir) \n");
                    }while(!opcion.equals("10"));

                    normalMenu(sistema,nombreUsuario);

                    break;

                case "2":
                    String synthesis = sistema.systemSynthesis(nombreUsuario);
                    System.out.println(synthesis);
                    break;

                case "3":
                    System.out.println("Ingresa tu semilla: \n");
                    int seed = scanner.nextInt();
                    System.out.println("Ingresa el maximo de iteraciones: \n");
                    int i = scanner.nextInt();
                    sistema.systemSymulate(i,seed);
                    break;

                case "4":
                    sistema.systemLogout();
                    registroMenu(sistema);
                    break;

            }

        } while (!entrada.equalsIgnoreCase("4"));

        scanner.close();
    }

    /**
     * Menu para modificar un chatbot
     * @param sistema
     * @param nombreUsuario
     * @param chatbot
     */
    public static void modificarChat(system_21022807_TapiaGalleguillos sistema, String nombreUsuario, Chatbot_21022807_TapiaGalleguillos chatbot){
        Scanner scanner = new Scanner(System.in);
        String entrada;

        do {

            System.out.println("1. Modificar Flows/Crear Flow (Crearas un flow si el Chatbot no contiene Flows\n");
            System.out.println("2. Modificar Options (No usar si el chatbot no contiene Flows) \n");
            System.out.println("3. Modificar ID\n");
            System.out.println("4. Modificar Nombre\n");
            System.out.println("5. Modificar Mensaje de bienvenida\n");
            System.out.println("6. Modificar startFlowId\n");
            System.out.println("7. Volver \n");
            System.out.println("\n Ingresa tu opcion: ");
            entrada= scanner.nextLine();

            switch (entrada){

                case "1":
                    if(chatbot.getFlows().isEmpty()){

                        System.out.println("Ingresa el id del Flow \n");
                        int id = scanner.nextInt();
                        System.out.println("Ingresa el nombre del Flow: \n");
                        String nombre = scanner.next();
                        List<Option_21022807_TapiaGalleguillos> optionsVacio = new ArrayList<Option_21022807_TapiaGalleguillos>();
                        Flow_21022807_TapiaGalleguillos flowNew = new Flow_21022807_TapiaGalleguillos(id,nombre,optionsVacio);
                        chatbot.chatbotAddFlow(flowNew);
                        modificarFlow(sistema,nombreUsuario,chatbot,flowNew);
                    }
                    System.out.println(chatbot.verChatbot());
                    System.out.println("Elige el flow a modificar segun su id \n");
                    int idFl = scanner.nextInt();
                    Flow_21022807_TapiaGalleguillos flowBuscado = chatbot.buscarFlow(idFl);
                    modificarFlow(sistema,nombreUsuario,chatbot,flowBuscado);
                    break;

                case "2":
                    System.out.println(chatbot.verChatbot());
                    System.out.println("Elige el flow que contiene la option, segun su id \n");
                    int idFl1 = scanner.nextInt();
                    Flow_21022807_TapiaGalleguillos flow = chatbot.buscarFlow(idFl1);
                    System.out.println(flow.verOptions());
                    System.out.println("Elige el Option a modificar segun su code \n");
                    String idCode = scanner.next();
                    Option_21022807_TapiaGalleguillos opBuscado = flow.buscarOption(idCode);
                    modificarOption(sistema,nombreUsuario,chatbot,flow,opBuscado);
                    break;

                case "3":
                    System.out.println("Ingresa el id nuevo: \n");
                    int idNuevo = scanner.nextInt();
                    chatbot.setChatbotID(idNuevo);
                    break;

                case "4":
                    System.out.println("Ingresa el nombre nuevo: \n");
                    String nombreNuevo = scanner.nextLine();
                    chatbot.setName(nombreNuevo);
                    break;

                case "5":
                    System.out.println("Ingresa el nuevo mensaje: \n");
                    String mensajeNuevo = scanner.nextLine();
                    chatbot.setWelcomeMessage(mensajeNuevo);
                    break;

                case "6":
                    System.out.println("Ingresa el startFlowId nuevo: \n");
                    int flowNuevo = scanner.nextInt();
                    chatbot.setStartFlowId(flowNuevo);
                    break;

                case "7":
                    adminMenu(sistema,nombreUsuario);
                    break;
            }

        } while (!entrada.equalsIgnoreCase("7"));

        scanner.close();
    }

    /**
     * Menu para modificar un flow
     * @param sistema
     * @param nombreUsuario
     * @param chatbot
     * @param flow
     */
    public static void modificarFlow(system_21022807_TapiaGalleguillos sistema, String nombreUsuario, Chatbot_21022807_TapiaGalleguillos chatbot, Flow_21022807_TapiaGalleguillos flow){
        Scanner scanner = new Scanner(System.in);
        String entrada;

        do {

            System.out.println("1. Crear Flow \n");
            System.out.println("2. Modificar Options/Crear Option (Si Flow no contiene options) \n");
            System.out.println("3. Modificar Id\n");
            System.out.println("4. Modificar NameMSG\n");
            System.out.println("5. Volver\n");
            System.out.println("\n Ingresa tu opcion: ");
            entrada= scanner.nextLine();

            switch (entrada){

                case "1":
                    System.out.println("Ingresa el id del Flow \n");
                    int id = scanner.nextInt();
                    System.out.println("Ingresa el nombre del Flow: \n");
                    String nombre = scanner.next();
                    List<Option_21022807_TapiaGalleguillos> optionsVacio = new ArrayList<Option_21022807_TapiaGalleguillos>();
                    Flow_21022807_TapiaGalleguillos flowNew = new Flow_21022807_TapiaGalleguillos(id,nombre,optionsVacio);
                    chatbot.chatbotAddFlow(flowNew);
                    modificarChat(sistema, nombreUsuario, chatbot);
                    break;

                case "2":
                    if(flow.getOption().isEmpty()){
                        System.out.println("Ingresa el code de Option \n");
                        int code = scanner.nextInt();
                        System.out.println("Ingresa el mensaje de Option: \n");
                        String nombreOp = scanner.nextLine();
                        scanner.nextLine();
                        System.out.println("Ingresa el chatbotCodeLink de Option: \n");
                        int cbLink = scanner.nextInt();
                        System.out.println("Ingresa el initialFlowCodeLink de Option: \n");
                        int flLink = scanner.nextInt();
                        List<String> keywordsVacio = new ArrayList<String>();
                        Option_21022807_TapiaGalleguillos optionNew = new Option_21022807_TapiaGalleguillos(code,nombreOp,cbLink,flLink,keywordsVacio);
                        flow.flowAddOption(optionNew);
                        modificarOption(sistema,nombreUsuario,chatbot,flow,optionNew);
                    }
                    System.out.println(flow.verOptions());
                    System.out.println("Elige el Option a modificar segun su code \n");
                    String idCode = scanner.next();
                    Option_21022807_TapiaGalleguillos opBuscado = flow.buscarOption(idCode);
                    modificarOption(sistema,nombreUsuario,chatbot,flow,opBuscado);
                    break;

                case "3":
                    System.out.println("Ingresa el id nuevo: \n");
                    int idNuevo = scanner.nextInt();
                    flow.setId(idNuevo);
                    break;

                case "4":
                    System.out.println("Ingresa el nombre nuevo: \n");
                    String nombreNuevo = scanner.nextLine();
                    flow.setNameMsg(nombreNuevo);
                    break;

                case "5":
                    adminMenu(sistema,nombreUsuario);
                    break;
            }

        } while (!entrada.equalsIgnoreCase("5"));

        scanner.close();
    }

    /**
     * Menu para modificar una option
     * @param sistema
     * @param nombreUsuario
     * @param chatbot
     * @param flow
     * @param option
     */
    public static void modificarOption(system_21022807_TapiaGalleguillos sistema, String nombreUsuario, Chatbot_21022807_TapiaGalleguillos chatbot, Flow_21022807_TapiaGalleguillos flow, Option_21022807_TapiaGalleguillos option){
        Scanner scanner = new Scanner(System.in);
        String entrada;

        do {

            System.out.println("1. Crear Option \n");
            System.out.println("2. Modificar Code \n");
            System.out.println("3. Modificar Message\n");
            System.out.println("4. Modificar  ChatbotCodeLink\n");
            System.out.println("5. Modificar initialFlowLink\n");
            System.out.println("6. Agregar Keywords\n");
            System.out.println("7. Volver");
            System.out.println("\n Ingresa tu opcion: ");
            entrada= scanner.nextLine();

            switch (entrada){

                case "1":
                    System.out.println("Ingresa el code de Option \n");
                    int id = scanner.nextInt();
                    System.out.println("Ingresa el mensaje de Option: \n");
                    String nombre = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Ingresa el chatbotCodeLink de Option: \n");
                    int cbLink = scanner.nextInt();
                    System.out.println("Ingresa el initialFlowCodeLink de Option: \n");
                    int flLink = scanner.nextInt();
                    List<String> keywordsVacio = new ArrayList<String>();
                    Option_21022807_TapiaGalleguillos optionNew = new Option_21022807_TapiaGalleguillos(id,nombre,cbLink,flLink,keywordsVacio);
                    flow.flowAddOption(optionNew);
                    modificarFlow(sistema,nombreUsuario,chatbot,flow);
                    break;

                case "2":
                    System.out.println("Ingresa el code nuevo: \n");
                    int codeNuevo = scanner.nextInt();
                    option.setCode(codeNuevo);
                    break;

                case "3":
                    System.out.println("Ingresa el message nuevo: \n");
                    String message = scanner.nextLine();
                    option.setMessage(message);
                    break;

                case "4":
                    System.out.println("Ingresa el chatbotCodeLink nuevo: \n");
                    int cbLinkNuevo = scanner.nextInt();
                    option.setChatbotCodeLink(cbLinkNuevo);
                    break;

                case "5":
                    System.out.println("Ingresa el initialFlowCodeLink nuevo: \n");
                    int flLinkNuevo = scanner.nextInt();
                    option.setInitialFlowCodeLink(flLinkNuevo);
                    break;

                case "6":
                    System.out.println("Ingresa el keyword a agregar : \n");
                    String newKey = scanner.nextLine();
                    option.getKeyword().add(newKey);
                    break;

                case "7":
                    adminMenu(sistema,nombreUsuario);
            }

        } while (!entrada.equalsIgnoreCase("7"));

        scanner.close();
    }

}

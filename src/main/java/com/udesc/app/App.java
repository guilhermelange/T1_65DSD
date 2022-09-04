package com.udesc.app;


import com.udesc.client.ClientApp;
import com.udesc.common.constants.Constants;
import com.udesc.server.ServerApp;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleciona o tipo de aplicação:");
        System.out.println(">> 1 = Server");
        System.out.println(">> 2 = Client");
        int appType = scanner.nextInt();
        
        try {
            switch (appType) {
                case 2:
                    System.out.println("Informe o Host");
                    Constants.SERVER_HOST = scanner.next();
                    System.out.println("Informa a porta");
                    Constants.SERVER_PORT = scanner.nextInt();
                    ClientApp.main(args);
                    break;
                case 1:
                    System.out.println("Informe a porta");
                    Constants.SERVER_PORT = scanner.nextInt();
                    ServerApp.main(args);
                    break;
                default:
                    System.out.println("Tipo não suportado");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

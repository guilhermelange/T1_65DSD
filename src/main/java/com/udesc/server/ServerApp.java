package com.udesc.server;

import com.udesc.common.constants.Constants;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Optional;

public class ServerApp {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Constants.SERVER_PORT);
        System.out.println("Servidor ativo na porta " + Constants.SERVER_PORT);
        
        while (true) {
            ServerHandler serverHandler = new ServerHandler(serverSocket.accept());
            serverHandler.start();
        }
    }
}

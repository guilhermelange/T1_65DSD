package com.udesc.server;

import com.udesc.common.constants.Constants;
import com.udesc.common.model.Familia;
import com.udesc.common.model.Pessoa;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;
import java.util.Map;

public class ServerApp {
    private Map<Familia, List<Pessoa>> familias;
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Constants.SERVER_PORT);
        
        while (true) {
            ServerHandler serverHandler = new ServerHandler(serverSocket.accept());
            serverHandler.start();
        }
    }
}

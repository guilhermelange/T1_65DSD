package com.udesc.server;

import com.udesc.patterns.Router;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler extends Thread {
    private Socket socket;
    
    public ServerHandler(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        System.out.println("Accepted connection request from " + socket.getInetAddress().getHostAddress());
        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String inputLine = in.readLine();
            String result = handleCommand(inputLine);
            out.println(result);
            socket.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
    
    private static String handleCommand(String inputLine) {
        Router router = new Router(inputLine);
        try {
            return router.handleControllerOperation();
        } catch (Exception e) {
            return "Erro ao executar comando: " + e.getMessage();
        }
    }
}

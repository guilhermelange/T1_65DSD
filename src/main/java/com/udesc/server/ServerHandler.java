package com.udesc.server;

import com.udesc.patterns.Router;
import java.io.BufferedReader;
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
        System.out.println("Conexão aceita para " + socket.getInetAddress().getHostAddress());
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String inputLine = in.readLine();
            String result = handleCommand(inputLine);
            out.println(result);
            socket.close();
        } catch (Exception e) {
            System.out.println("Erro interno: " + e.getMessage());
        }
    }
    
    private static String handleCommand(String inputLine) {
        try {
            Router router = new Router(inputLine);
            return router.handleControllerOperation();
        } catch(IndexOutOfBoundsException e) {
            return "Parâmetros insuficientes!";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}

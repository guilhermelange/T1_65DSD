package com.udesc.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

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
        String result = inputLine + " response \n quebra \n quebra2";
        List<String> data = Arrays.asList(inputLine.split(";"));
        
        String operation = data.get(0);
        return result;
    }
}

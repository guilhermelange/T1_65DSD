package com.udesc;

import com.udesc.common.model.Familia;
import com.udesc.common.model.Pessoa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ServerApp {
    private Map<Familia, List<Pessoa>> familias;
    
    public static void main(String[] args) throws IOException {
        int portNumber = 80;
        ServerSocket serverSocket = new ServerSocket(portNumber);
        
        while (true) {  
            Socket conn = serverSocket.accept(); 
            try (
                PrintWriter out = new PrintWriter(conn.getOutputStream(), true);                   
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            ) {
                String inputLine = in.readLine();
                String result = handleCommand(inputLine);
                out.println(result);
            } catch (IOException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            } finally {
                conn.close();
            }
        }
    }

    private static String handleCommand(String inputLine) {
        String result = inputLine + " response \n quebra \n quebra2";
        List<String> data = Arrays.asList(inputLine.split(";"));
        
        String operation = data.get(0);
        
//        switch (operation) {
//            case "LIST":
//                break;
//        }
        
        
        return result;
    }
}

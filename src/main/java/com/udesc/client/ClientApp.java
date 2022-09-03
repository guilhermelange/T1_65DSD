package com.udesc.client;

import com.udesc.common.constants.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            sendMessage(command);
        }
    }

    private static boolean sendMessage(String command) throws IOException {
        Socket socket = new Socket(Constants.SERVER_HOST, Constants.SERVER_PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out.println(command);
        out.flush();
        
        if (command.equals("exit")) {
            return true;
        }
        
        String result;
        while ((result = in.readLine()) != null) {
            System.out.println(result);
        }
        return false;
    }
}

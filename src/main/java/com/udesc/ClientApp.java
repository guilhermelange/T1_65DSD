package com.udesc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();

            Socket socket = new Socket("127.0.0.1", 80);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println(str);
            out.flush();
            
            if (str.equals("exit"))
                break;
            
            String result;
            while ((result = in.readLine()) != null) {                
                System.out.println(result);
            }
        }
    }
}

package com.udesc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 80);
        Scanner scanner = new Scanner(System.in);

        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while (true) {
            System.out.println("Please enter the message you want to send to the server side:");

            String str = scanner.nextLine();
            out.println(str);
            out.flush();
            System.out.println(in.readLine());
        }
    }
}

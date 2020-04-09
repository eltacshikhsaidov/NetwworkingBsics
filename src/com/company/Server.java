package com.company;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Server(int port){
        try{
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server is started");

            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();

            System.out.println("Client is accepted");

            System.out.print("You entered: ");

            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            while (!line.equals("Over")){
                try{
                    line = dataInputStream.readUTF();
                    System.out.println(line);
                } catch (IOException i){
                    i.printStackTrace();
                }
            }

            System.out.println("Closing connection");
            socket.close();
            dataInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server(5000);
    }
}

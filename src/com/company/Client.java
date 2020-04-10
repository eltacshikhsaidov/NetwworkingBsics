package com.company;

import java.net.*;
import  java.io.*;

public class Client {

    private Client(String address, int port){
        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            socket = new Socket(address, port);
            System.out.println("Connected\n");

            System.out.print("Please enter something: ");
            dataInputStream = new DataInputStream(System.in);

            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line = "";

        while (!line.equals("Over")){
            try{
                assert dataInputStream != null;
                line = dataInputStream.readLine();
                assert dataOutputStream != null;
                dataOutputStream.writeUTF(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try{
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 5000);
    }
}

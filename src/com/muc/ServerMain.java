package com.muc;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class ServerMain {
    public static void main(String[] args) throws IOException{
        int port = 8818;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("About to accept client connection.");
                Socket clientSocket = serverSocket.accept();
                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write("Java socket programing by Roman deVille!\n".getBytes());
                for(int i=0; i < 10; i++) {
                    outputStream.write(("Time now is " + new Date() + "\n").getBytes());
                    Thread.sleep(1000);
                }
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

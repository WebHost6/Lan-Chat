package com.example;
import java.op.*;
import java.io.IOError;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String [] args)
    {
        int portNum = 6942;
        serverSocket = null;
        try {
            ServerSocket serverSocket = new serverSocket(portNum);
        } catch (IOException e) {
            System.err.println("coould not start server on port " + portNum);
            System.exit(1);
        }
1    }
    
}


import java.io.IOError;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Server {
    private static int portNum = 2642;
    private int serverPort;
    
    public static void main(String [] args)
    {
        try (ServerSocket serverSocket = new ServerSocket(portNum)){
            System.out.println(portNum);
        } catch (IOException e) {
            System.err.println("could not start server on port " + portNum);
            System.exit(1);
        }
    }
    
}

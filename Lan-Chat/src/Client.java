import java.io.IOError;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class Client {
    private String name;
    private int userID;
    private int serverPort;

    private Client(String name, int userID, int serverPort)
    {
        this.name = name;
        this.userID = userID;
        this.serverPort = serverPort;
        
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("[?] please enter the username you wish to use.");
        String username = input.nextLine();
        //TODO get userID

        
       
    }

    private void clientThread()
    {
        
    }
}

import java.io.IOError;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Server {
    private static int portNum = 2642;
    private int serverPort;

    // maximum amount of clients allowed -- changeable
    private List<ClientThread> clients;
    
    public Server(int portNum)
    {
        this.serverPort = portNum;
    }

    // getClients() returns clients
    public List<ClientThread> getClients()
    {
        return clients;
    }
    
    public static void main(String [] args)
    {
        Server server = new Server(portNum);
        server.start();
    }

    private void connect(ServerSocket serverSocket)
    {
        while (true) {
            Socket socket = serverSocket.accept();
            // continue
        }
    }

    private void start()
    {
        clients = new ArrayList<ClientThread>();
        
        try (ServerSocket serverSocket = new ServerSocket(portNum)){
            System.out.println(portNum);
            
        } catch (IOException e) {
            System.err.println("could not start server on port " + portNum);
            System.exit(1);
        }
    }
    
}

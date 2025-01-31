import java.io.IOError;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;


public class Client {
    private static final String host = "localhost";
    private static final int port = 2642;

    private String name;
    private int userID;
    private int serverPort;
    private String serverHost;

    private Client(String name, int userID, int serverPort, String host)
    {
        this.name = name;
        this.userID = userID;
        this.serverPort = serverPort;
        this.serverHost = host;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("[?] please enter the username you wish to use.");
        String username = input.nextLine();
        
        // TODO get userID from server class
        String userID = "";
        
        Client client = new Client(username, userID, port, host);
    }

    private void start()
    {
        try {
            Socket socket = new Socket(serverHost, serverPort);
            
            Thread.sleep(2000);
            ServerThread serverThread = new ServerThread(socket, userID, name);
            Thread thread = new Thread(serverThread);
            
            while (thread.isAlive()) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextLine()) {
                    serverThread.sendMessage(scanner.nextLine());
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

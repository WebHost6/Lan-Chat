import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerThread implements Runnable
{
    private Socket socket;
    private String userID;
    private String username;
    private List<String> messages;
    
    public ServerThread(Socket socket, String userID, String username )
    {
        this.username = username;
        this.userID = userID;
        this.socket = socket;
        messages = new ArrayList<String>();
        //messages = new List<String>();
    }

    public void sendMessage(String message) {
        messages.add(message);
    }

    @Override
    public void run()
    {
        System.out.println("Welcome " + username);

        try {
            PrintWriter out = PrintWriter(socket.getOutputStream(), false);

            while (!socket.isClosed()) {
                if (socket.getInputStream().available() > 0) {
                    Scanner scanner = new Scanner(socket.getInputStream());

                    if (scanner.hasNextLine()) {
                        String message = scanner.nextLine();
                        System.out.println("Received message: " + message);
                        //server.broadcast(message, this);
                    }
                    scanner.close();
                }
                
                System.out.flush();
            }   
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
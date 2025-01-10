import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable
{
    private Socket socket;
    private String userID;
    
    @Override
    public void run()
    {
        try {
            
            while (!socket.isClosed()) {
                if (socket.getInputStream().available() > 0) {
                    Scanner scanner = new Scanner(socket.getInputStream());
                    if (scanner.hasNextLine()) {
                        String message = scanner.nextLine();
                        System.out.println("received message: " + message);
                        server.broadcast(message, this);
                    }
                    scanner.close();
                }
                
            }   
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
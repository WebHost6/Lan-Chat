import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread implements Runnable
{
    private Socket socket;
    private Server server;
    private PrintWriter writer;

    public ClientThread(Socket socket, Server server)
    {
        this.socket = socket;
        this.server = server;
    }

    // terminal resize detection

    @Override
    public void run()
    {
        try {
            this.writer = new PrintWriter(socket.getOutputStream(), false);
            Scanner scanner = new Scanner(socket.getInputStream());

            while (!socket.isClosed()) {
                if (scanner.hasNextLine()) {
                    String message = scanner.nextLine(); // message from the client
                    
                    // broadcasting the server
                    for (ClientThread client: server.getClients()) {
                        if (client.out != null) {
                            client.out.println(message + "\n");
                        }
                    }
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
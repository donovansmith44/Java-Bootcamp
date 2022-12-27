import java.net.*;
import java.io.*;

class echoServer{
    public static void main(String[] args) {
        System.out.println("Echo server");
        try (ServerSocket echoServer = new ServerSocket(9999)){
            System.out.println("Waiting for connection...");
            Socket clientSocket = echoServer.accept();
            System.out.println("Conneted to client!");
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)){
                String message;
                while((message = reader.readLine()) != null)
                {
                    System.out.println("Server: " + message);
                    out.println(message);
                }
                }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
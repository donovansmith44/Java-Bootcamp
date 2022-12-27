import java.net.*;
import java.util.Scanner;
import java.io.*;
public class echoClient {
    public static void main(String[] args) {
        System.out.println("Echo client");
        try{
            System.out.println("Waiting for connection...");
            InetAddress localAddress = InetAddress.getLocalHost();

            try (Socket clientSocket = new Socket(localAddress, 9999);
                    PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
                    System.out.println("Connected to server");
                    Scanner scanner = new Scanner(System.in);
                    while(true)
                    {
                        System.out.println("Enter text:");
                        String message = scanner.nextLine();
                        if("quit".equalsIgnoreCase(message))
                        {
                            break;
                        }
                        out.println(message);
                        String response =  reader.readLine();
                        System.out.println("Server response: " + response);
                    }
                    }
        } catch(IOException e){
        }
    }
}

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
            // TODO: handle exception
        }
    }
}
// import java.net.*;
// import java.io.*;

// class echoServer{
//     public static void main(String[] args) throws IOException {
//         if(args.length != 1)
//         {
//             System.err.println("Usage: java EchoServer <port number>");
//             System.exit(1);
//         }
//         int port = Integer.parseInt(args[0]);

//         try(
//             ServerSocket myEchoServer = new ServerSocket(Integer.parseInt(args[0]));
//             Socket myClientSocket = myEchoServer.accept();
//             PrintWriter out = new PrintWriter(myClientSocket.getOutputStream(), true);
//             BufferedReader in = new BufferedReader(new InputStreamReader(myClientSocket.getInputStream()));
//         )
//         {
//             String message;
//             while((message = in.readLine()) != null)
//             {
//                 out.println(message);
//             }
//         }
//         catch(IOException e){
//             System.out.println("Exception caught when listening on port " + port + " or listening for connection");
//             System.out.println(e.getMessage());
//         }
        
//     }
// }
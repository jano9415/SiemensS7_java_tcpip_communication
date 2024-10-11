import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {

        // create a server socket on port number 9090
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9090);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Server is running and waiting for client connection...");

        // Accept incoming client connection
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Client connected!");

        // Setup input and output streams for communication with the client
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Read message from client
        String message = null;
        try {
            message = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Client says: " + message);

        // Send response to the client
        out.println("Message received by the server.");

        // Close the client socket
        try {
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Close the server socket
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
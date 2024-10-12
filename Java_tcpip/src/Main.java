import java.io.*;
import java.net.*;


public class Main {
    public static void main(String[] args) {

        // create a socket to connect to the server running on 192.168.0.10 at port number 2000
        Socket socket = null;
        try {
            socket = new Socket("192.168.0.10", 2000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Setup output stream to send data to the server
        PrintWriter out = null;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Setup input stream to receive data from the server
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(socket.isConnected() + ": Connection successful");
        System.out.println(socket.isClosed() + ": Connection closed");
        // Send message to the server
        out.print(4);

        /*
        // Receive response from the server
        String response = null;
        try {
            response = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Server says: " + response);
         */

        // Close the socket
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
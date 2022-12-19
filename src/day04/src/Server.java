import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] ars){

        System.out.println("SOCKET SERVER : ");
        int PORT = 12345;

        // Create ServerSocket
        try {
            ServerSocket server = new ServerSocket(PORT);
            Socket socket = server.accept();
            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            // String msg = dis.readUTF();
            // System.out.println("MSG Received: " + msg);
            // socket.close();
            String fromClient = dis.readUTF();
            while (!fromClient.equalsIgnoreCase("close") && fromClient != null) {
                // Process msg
                System.out.println("MSG Received: " + fromClient);
                // Read the next line from the input stream
                fromClient = dis.readUTF();

            }
            System.out.println("Socket closing");
            socket.close();

        } catch (IOException e) {
            System.out.println("IO Error" + e.getMessage());
        }
        
    }
}
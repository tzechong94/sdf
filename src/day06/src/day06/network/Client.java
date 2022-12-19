package day06.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {

        // boolean stop = true;
        // Get list size

        Integer n = Integer.parseInt(args[0]);

        //Get limit
        Integer limit = Integer.parseInt(args[1]);

        //get host
        String hostName = args[2];

        //get port
        Integer port = Integer.parseInt(args[3]);

        //Create the socket to server
        Socket socket = new Socket(hostName, port);
        System.out.printf("Connected to %s:%d on %d\n", hostName, port, socket.getPort());

        // My answer
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));    

        dos.writeUTF(Integer.toString(n) + "," + Integer.toString(limit));
        dos.flush();
        System.out.println("Sent " + Integer.toString(n) + ", " + Integer.toString(limit));

        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String line = dis.readUTF();
        System.out.println(line);
    
        // String response = IOUtils.read(socket);
        // System.out.println(response);
        socket.close();
        
        // end of my answer

        // IOUtils.write(socket, "%d %d".formatted(n,limit));


    }
    
}

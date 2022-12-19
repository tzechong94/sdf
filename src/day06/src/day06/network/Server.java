package day06.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Server {
    

    public static void main(String[] args) throws Exception{

        Integer PORT = Integer.parseInt(args[0]);
        Integer n;
        Integer limit;
        ServerSocket server = new ServerSocket(PORT);
        System.out.printf("listening on port %d\n", PORT);
        Random rnd = new SecureRandom();

        //server loop
        while (true) {
            Integer total = 0;
            Socket socket = server.accept();

            // My answer 
            
            List<Integer> listOfNumbers = new ArrayList<Integer>();;
            System.out.println("Waiting for connections");
            System.out.printf("New connection from %d\n", socket.getPort());
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String[] line = dis.readUTF().split(",");
            n = Integer.parseInt(line[0]);
            limit = Integer.parseInt(line[1]);
            for (Integer i = 0; i < n; i++) {
                listOfNumbers.add(rnd.nextInt(limit));
            }

            // streams 
            // String response = listOfNumbers.stream()
            //     .map(v -> v.toString())
            //     .collect(Collectors.joining(":"));

            // IOUtils.write(socket, response);
            // end of streams 

            System.out.println(listOfNumbers);
            
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));    
            for (Integer i : listOfNumbers) {
                total += i;
            }
            dos.writeUTF("Average is " + Integer.toString(total/listOfNumbers.size()));
            dos.flush();
            listOfNumbers.removeAll(listOfNumbers);
            

            // socket.close();
            // server.close();
            // end of my answer

            // String payload = IOUtils.read(socket);
        }
        // System.out.println(intList);
        







    }
}

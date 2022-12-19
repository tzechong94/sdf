import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HandleClient implements Runnable{
    
    private Socket socket; 
    private Random rnd = new SecureRandom();

    
    public HandleClient(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {

    List<Integer> listOfNumbers = new ArrayList<Integer>();;
    System.out.printf("New connection from %d\n", socket.getPort());



    // My answer 
    System.out.println(Thread.currentThread());
    System.out.println(String.format("Current thread: %s\n", Thread.currentThread().getName()));
    String[] line;
    Integer total = 0;
    try {
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        line = dis.readUTF().split(",");
        Integer n = Integer.parseInt(line[0]);
        Integer limit = Integer.parseInt(line[1]);
        for (Integer i = 0; i < n; i++) {
            listOfNumbers.add(rnd.nextInt(limit));
        }        
        System.out.println(listOfNumbers);

        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));    
        for (Integer i : listOfNumbers) {
            total += i;
        }
        dos.writeUTF("Average is " + Integer.toString(total/listOfNumbers.size()));
        dos.flush();
        listOfNumbers.removeAll(listOfNumbers);

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
}

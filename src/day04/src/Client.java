import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    
    public static void main(String[] args){
        int PORT = 12345;
        try {
            Socket cs = new Socket("localhost", PORT);

            // Get the I/O string
            OutputStream os = cs.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            // dos.writeUTF("Hello, world!");
            // dos.writeUTF("How are you?");
            // dos.flush();
            // System.out.println("MESSAGE SENT TO SERVER");
            // cs.close();
            Scanner inputSc = new Scanner(System.in);
            String line;
            while ((line = inputSc.nextLine()) != null) {
                if (line.equalsIgnoreCase("close")) {
                    System.out.println("Exit from shell");
                    break;
                }
                dos.writeUTF(line);
                dos.flush();
                System.out.println("MSG sent to server: " + line);
            }
            cs.close();
            inputSc.close();

        } catch (UnknownHostException e) {
            System.out.println("Unable to reach HOST");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }
}

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {


    public static void main(String[] args) {
        try {
            Socket cs = new Socket("localhost", 12000);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(cs.getOutputStream()));

            //Read a file
            FileReader fr = new FileReader("src/input.txt");
            BufferedReader bfr = new BufferedReader(fr);
            String line;

            while (null != (line = bfr.readLine())){
                dos.writeUTF(line);
                dos.flush();
            } 

            // send an EOF identifier to server
            dos.writeUTF("EOF");
            dos.flush();

            bfr.close();
            cs.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class IOUtils {
  
    public static void write(Socket socket, String payload) throws IOException {

        // Get the output stream
        OutputStream os = socket.getOutputStream();
        // Buffered stream knows the maximum transfer unit, know what is the best size to write
        BufferedOutputStream bos = new BufferedOutputStream(os); // These are just decorators on the output stream
        DataOutputStream dos = new DataOutputStream(bos);

        // Write the string as UTF
        System.out.printf("payload >>>> %s\n", payload);
        dos.writeUTF(payload);
        dos.flush();
        // dos.close();
        // bos.close();
        // os.close(); // close in reverse order
    }

    public static String read(Socket socket) throws IOException {
        // get the input stream

        InputStream is = socket.getInputStream();
        // Buffered stream knows the maximum transfer unit, know what is the best size to write
        BufferedInputStream bis = new BufferedInputStream(is); // These are just decorators on the output stream
        DataInputStream dis = new DataInputStream(bis);

        //Read payload from the input stream
        String payload = dis.readUTF();
        System.out.printf("<<< %s\n", payload);

        // dis.close();
        // bis.close();
        // is.close();
        return payload;
    }
}

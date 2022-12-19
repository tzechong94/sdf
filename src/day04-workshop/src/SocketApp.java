import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * SocketApp
 */

public class SocketApp {
    
    public static void main(String[] args) {

        // String usage = """
        // Usage: Server 
        // ============
        // <program> <server> <port> <src/cookie-file.txt>
        // Usage: Client
        // ============
        // <program> <client> <host> <port>
        // """;

        if ((args.length) != 3) {
            System.out.println("Incorrect inputs. Please check the following usage.");
            System.out.println("hi");
            return;
        }

        String type = args[0];
        if (type.equalsIgnoreCase("server")) {
            int port = Integer.parseInt(args[1]);
            //String fileName = args[2];
            StartServer(port);
        } else if (type.equalsIgnoreCase("client")) {
            String hostName = args[1];
            int port = Integer.parseInt(args[2]);
            StartClient(hostName,port); 
        } else {
            System.out.println("Incorrect arguments!");
        }
    }

    public static void StartServer(int port) {
        CookieFile cookieFile = new CookieFile();

        ServerSocket server;
        try {
            server = new ServerSocket(port);
            Socket socket = server.accept();
            //IN
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                //OUT
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            while (true) {
                String fromClient = dis.readUTF();
                
                if (fromClient.equalsIgnoreCase("exit")) {
                    // exit
                    break;
                } 
                System.out.println("LOG: msg from client: " + fromClient);
                
                if (fromClient.equalsIgnoreCase("getcookie")) {
                    // send a random cookie from the file
                    
                    // dos.writeUTF("Dummy cookie..");
                    //implement this class
                    dos.writeUTF(cookieFile.GetRandomCookieFromFile("/Users/tzechong/Desktop/TFIP/src/day04-workshop/src/cookies.txt"));
                    // dos.writeUTF(cookieFile.GetRandomCookieFromFile("src/cookies.txt"));

                    dos.flush();
                } 
                else {
                    // send a message "invalid command from server"
                    dos.writeUTF("From server: Invalid command");
                    dos.flush();
                }
            }
                
            socket.close(); 
            
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public static void StartClient(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            //IN
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            //OUT
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            Scanner sc = new Scanner(System.in);
            boolean stop = false;
            while (!stop) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("exit")) {
                    dos.writeUTF("exit");
                    dos.flush();
                    stop = true;
                    break;
                } 
                dos.writeUTF(line);
                dos.flush();
                String fromServer = dis.readUTF();
                System.out.println("Resp from server! " + fromServer);
            }
            sc.close();
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }



}

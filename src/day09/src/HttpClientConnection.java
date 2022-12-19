import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class HttpClientConnection implements Runnable{
    
    private Socket socket;
    String serverResponse; 
    String methodName;
    String resourceName;
    String resourceContent = "";
    byte[] imageContent;

    public HttpClientConnection(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ReadReq();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void ReadReq() throws Exception {
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = socket.getOutputStream();
        HttpWriter writer = new HttpWriter(os);




        String clientRequest = br.readLine(); 
        methodName = clientRequest.split(" ")[0];
        resourceName = clientRequest.split(" ")[1];

        System.out.println("client request: " + clientRequest);
        System.out.println("Method name: " + methodName);
        System.out.println("resourceName: " + resourceName);
        //Not a get method 
        if (!methodName.equals("GET")) {
            serverResponse = "HTTP/1.1 405 Method Not Allowed\r\n\r\n " + methodName + " not supported\r\n";
            writer.writeString(serverResponse); 

            System.out.println(serverResponse);
            writer.writeString();
            socket.close();
        }
        
        // Resource does not exist
        if (resourceName.equals("/")) {
            resourceName = "/index.html";
        }

        // resource exists
        if (methodName.equals("GET")) {
        for (String docRootPath : HttpServer.docRoot) {

            File dir = new File(docRootPath + resourceName);
            if (!dir.exists()) {
                serverResponse = "HTTP/1.1 404 Not Found\r\n\r\n " + resourceName + " not found\r\n";
                System.out.println(serverResponse);
                writer.writeString(serverResponse); 
                socket.close();
            } else { 
                File file = new File(docRootPath + resourceName);
                FileReader fr = new FileReader(file);
                BufferedReader htmlReader = new BufferedReader(fr);
                String fileLine;
                
                if (resourceName.endsWith(".png")) {
                    // File imageFile = new File(docRootPath + resourceName);
                    // System.out.println(docRootPath + resourceName);
                    // FileInputStream fis = new FileInputStream(imageFile);
                    // byte[] imageContent = new byte[(int) imageFile.length()];
                    // System.out.println(imageContent.length);
                    // fis.read(imageContent);
                    // fis.close();
                    Path imagePath = Paths.get(docRootPath + resourceName);
                    System.out.println("image path: " + imagePath);
                    imageContent = Files.readAllBytes(imagePath);
                    System.out.println(imageContent);
                    writer.writeString("HTTP/1.1 200 OK\r\n");
                    writer.writeString("Content-Type: image/png\r\n");
                    writer.writeString("Content-Length: " + imageContent.length);
                    writer.writeString("r\n");
                    writer.writeBytes(imageContent);
                    writer.flush();
                    writer.close();
                    System.out.println(imageContent.length);
                    
                    // writer.close();
                    // socket.close();
                } 
                else if (!resourceName.endsWith(".png")) {
                    while ((fileLine = htmlReader.readLine())!=null) {
                        resourceContent += fileLine + "\n";
                    }
                    serverResponse = "HTTP/1.1 200 OK\r\n\r\n" + resourceContent;
                    System.out.println(resourceContent);
                    System.out.println(serverResponse);
                    writer.writeString(serverResponse); 
                    writer.flush();
                    writer.close();
                    // socket.close();
                
                // System.out.println("BEFORE CLOSING");
                }
                htmlReader.close();

            }

        }

    }
            // resource exist and is a png image
    }
}


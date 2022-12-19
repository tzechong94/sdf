import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    
    Integer port;
    static List<String> docRoot = new ArrayList<>();
    static String path;
    ExecutorService threadpool = Executors.newFixedThreadPool(3);
    
    public HttpServer() {
        this.port = 3000;
        docRoot.add("./target");
    }

    public HttpServer(Integer port, List<String> docRootList) {
        this.port = port;
        docRoot = docRootList;
    }

    public void start() throws Exception {
        ServerSocket server = new ServerSocket(this.port);
        System.out.printf("Listening on port %d\n", this.port);

        for (Integer i = 0; i < docRoot.size(); i++) {
            path = docRoot.get(i);
            File file = new File(path);
            if (!file.exists()) {
                System.exit(1);
            }
            if (!file.isDirectory()){
                System.exit(1);
            }
            if (!file.canRead()){
                System.exit(1);
            }


        }
        while (true) {
            System.out.println("Waiting for connections...");
            Socket socket = server.accept();

            HttpClientConnection client = new HttpClientConnection(socket);

            threadpool.submit(client);
        }


    }

}


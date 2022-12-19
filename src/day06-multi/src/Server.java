
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    
    static ExecutorService threadpool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws Exception{

        // different threads for different client. print out thread name
       
        // for (int i = 0; i < 2; i++) {
        //     threadpool.execute(()->{
        //         System.out.println(String.format("starting expensive task thread %s", Thread.currentThread().getName()));
        //     });
        // }


        Integer PORT = Integer.parseInt(args[0]);
        // Integer n;
        // Integer limit;
        ServerSocket server = new ServerSocket(PORT);
        System.out.printf("listening on port %d\n", PORT);



        // Thread object = new Thread(new MultiThread());
        // object.start();
        // for (Integer i = 0; i < 10; i++) {
        //     System.out.println("Main Thread id: " + Thread.currentThread().getId());
        // }


        //server loop
        while (true) {
            System.out.println("Waiting for connections");
            Socket socket = server.accept();

            //Create handleClient

            HandleClient client = new HandleClient(socket);
            // do not do this - client.run() this is not a thread.
            threadpool.submit(client);
        

            // DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            // String[] line = dis.readUTF().split(",");
            // n = Integer.parseInt(line[0]);
            // limit = Integer.parseInt(line[1]);
            // for (Integer i = 0; i < n; i++) {
            //     listOfNumbers.add(rnd.nextInt(limit));
            // }

            // streams 
            // String response = listOfNumbers.stream()
            //     .map(v -> v.toString())
            //     .collect(Collectors.joining(":"));

            // IOUtils.write(socket, response);
            // end of streams 

            

            // socket.close();
            // server.close();
            // end of my answer

            // String payload = IOUtils.read(socket);
        }

    }

    
}


import java.util.ArrayList;
import java.util.List;

public class Main {

    static Integer port = 0;
    static List<String> docRoot = new ArrayList<>();

    public static void main(String[] args) throws Exception {


        //java -cp ./myserver.jar
        //java -cp ./myserver.jar --port 8080
        //java -cp ./myserver.jar --docRoot
        //java -cp ./myserver.jar --port 8080 --docRoot
        
        if (args.length == 0) {
            port = 3000;
            docRoot.add("./target");
        } else if (args.length == 2) {
            if (args[0].equals("--port")) {
                port = Integer.parseInt(args[1]);
                docRoot.add("./target");
                System.out.println(port);
            }
            else if (args[0].equals("--docRoot")) {
                port = 3000;
                for (Integer i = 0; i < args[1].split(":").length;i++){
                    docRoot.add(args[1].split(":")[i]);
                }
                System.out.println(port);
            }
        } else if (args.length == 4) {
            if (args[0].equals("--port") && args[2].equals("--docRoot")) {
                port = 3000;
                for (Integer i = 0; i < args[3].split(":").length;i++){
                    docRoot.add(args[3].split(":")[i]);
                }
            }
        }

        System.out.println("args length: " + args.length);
        System.out.println(docRoot);
        System.out.println(port);
        HttpServer httpserver = new HttpServer(port, docRoot);
        httpserver.start();




    }
}
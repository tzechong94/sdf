
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingCartDB {

    public static final String LOGIN = "login";
    public static final String ADD = "add";
    public static final String LIST = "list";
    public static final String SAVE = "save";
    public static final String EXIT = "exit";
    public static final String USERS = "users";

    public static final List<String> VALID_COMMANDS = 
    Arrays.asList("login", "add", "list", "exit", "users", "save");

    private CartDBInMemory db;
    private String currentUser;
    private String baseFolder;

    public ShoppingCartDB() {
        this.baseFolder = "db";
        this.setup();
        this.db = new CartDBInMemory(this.baseFolder);
    }

    public ShoppingCartDB(String baseFolder) {
        this.baseFolder = baseFolder;
        this.setup();
        this.db = new CartDBInMemory(baseFolder);
    }

    public void setup(){
        Path p = Paths.get(this.baseFolder);
        // Create 
        // File f = new File(this.baseFolder);
        if (Files.isDirectory(p)) {
            // SKIP if directory already exists
        } else {
            try {
                Files.createDirectory(p);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void startShell(){
        System.out.println("Welcome to MultiUser Shopping Cart >> ");

        Scanner sc = new Scanner(System.in);
        // Scanner sc = new Scanner("add apple, orange, pear");

        Boolean stop = false;
        String line;
        
        while (!stop) {
                line = sc.nextLine();
                line = line.trim();
                System.out.println("=>" + line);
    
                if (line.equalsIgnoreCase("exit")) {
                    stop = true;
                }
    
                //Validate COmmand
                if (!this.ValidateInput(line)) {
                    System.out.println("Invalid input. ");
                } else {
                    System.out.println("Processing : " + line);
                    this.ProcessInput(line);
                }
            }
        sc.close();

        }



        public boolean ValidateInput(String input) {
            String[] parts = input.split(" ");
            String command = parts[0].trim();

            // Scanner lsc = new Scanner(input);
            // String command = lsc.next().trim();
            // valid command
            return VALID_COMMANDS.contains(command);
        }
        

        //Process Command
        public void ProcessInput(String input) {
            Scanner sc = new Scanner(input);
            String command = sc.next().trim();

            switch (command) {
                case LOGIN:
                    try {
                        String username = sc.nextLine().trim();
                        this.LoginAction(username);
                        System.out.println("current logged in user: " + username);
                        break;     
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e);
                        break;
                    }

                case LIST:
                    try {
                        this.ListAction(null);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e);
                        break;
                    }

                case ADD:
                    try {       
                        String[] items = sc.nextLine().trim().split(",");
                        this.AddAction(items);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e);
                        break;
                    }

                case SAVE:
                    try {
                        this.SaveAction(this.baseFolder + "/" + this.currentUser + ".db");
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e);
                        break;
                    }


                case EXIT:
                    System.out.println("Goodbye!");
                    break;

                case USERS:
                    this.UsersList();
                    break;

                default:
                    System.out.println("Invalid input");
                    break;

            }

            sc.close();
        }

        public void UsersList() {
            File f = new File("cartdb");
            String[] userList = f.list();
            for (Integer i = 0; i < userList.length; i++) {
                if (userList[i].indexOf(".") > 0) {
                    System.out.println(i+1 + ". " + userList[i].substring(0, userList[i].lastIndexOf(".")));
        }

            
        //     for (String item : userList) {
        //         if (item.indexOf(".") > 0) {
        //             System.out.println(item.substring(0, item.lastIndexOf(".")));
        // }
    }}

        //Command: login <username>
        public void LoginAction(String username) {
            if (!this.db.userMap.containsKey(username)){
                this.db.userMap.put(username, new ArrayList<String>());
            }
            this.currentUser = username;
        }

        public void AddAction(String[] items) {
            for (String item: items) {
                this.db.userMap.get(this.currentUser).add(item);
            }
        }

        public void ListAction(String[] items) {
            for (String item: this.db.userMap.get(this.currentUser)) {
                System.out.println("Item -> " + item);
            }
        }

        public void SaveAction(String username){
            try {
                FileWriter fw = new FileWriter(username, false);
                BufferedWriter bfw = new BufferedWriter(fw);
                for (String item: this.db.userMap.get(this.currentUser)) {
                    bfw.write(item+"\n");
                } 
                System.out.println("Your cart has been saved");
                bfw.flush();
                bfw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }



    }


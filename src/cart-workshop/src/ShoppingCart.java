import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ShoppingCart {

    public final String ADD = "add";
    public final String LIST = "list";
    public final String LOGIN = "login";
    public final String SAVE = "save";
    public final String USERS = "users";
    public final String EXIT = "exit";

    private String baseFolder = "cartdb";

    private String currentUser;
    public HashMap<String, ArrayList<String>> userMap = new HashMap<String, ArrayList<String>>();
    public ArrayList<String> cart;
    
    public void runCart() {
        this.loadUserFiles();
        Boolean stop = false;
        this.currentUser = "hi";
        // add, list, login, save, users 
        Scanner myObj = new Scanner(System.in);
        System.out.println("Welcome to your shopping cart.");

        while (!stop) {

            String userInput = myObj.nextLine();
            String[] commands = userInput.split("[\\s,]+");
            
            switch(commands[0].trim().toLowerCase()) {
                case ADD:
                    this.addAction(commands);
                    break;

                case LIST:
                    this.listAction();
                    break;

                case LOGIN:
                    System.out.println("Logged in user: " + commands[1].trim());
                    this.loginAction(commands[1].trim());
                    break;
                
                case SAVE:
                    this.savingFiles(this.baseFolder + "/" + this.currentUser + ".db");
                    break;

                case USERS: 
                    this.usersAction();
                    break;

                case EXIT: 
                    stop = true;
                    myObj.close();
                    break;

                default:
                    System.out.println("Invalid command.");
                    break;

            }
            
        }
    }


    private void loadUserFiles(){
        // userMap. read cartdb, key is file name, data is data
        File f = new File(this.baseFolder);
        File[] filteredFiles = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String filename) {
                return filename.endsWith("db");
            }

        });

        if (filteredFiles.length == 0) {
            return;
        }

        for (File file : filteredFiles ) {
            String userKey = file.getName().replace(".db", "");
            this.userMap.put(userKey, ReadFile(file));
        }

    }

    private ArrayList<String> ReadFile(File f) {
        ArrayList<String> dataList = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f)); 
            String line;
            while ((line = br.readLine()) != null) {
                dataList.add(line.trim());
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return dataList;

    }

    private void usersAction() {
        System.out.println("List of users: ");
        for (String item : this.userMap.keySet()) {
            System.out.println(item);
        }
    }


    private void loginAction(String userName) {
        this.currentUser = userName;
        if (!this.userMap.containsKey(userName)) {
            this.userMap.put(userName, new ArrayList<String>());
        }
    }



    private void listAction() {
        cart = userMap.get(this.currentUser);
        for (String item: this.cart) {
            System.out.println("Item -> " + item);
        }
    }


    private void addAction(String[] list) {
        for (Integer i = 1; i < list.length; i++) {
            System.out.println("Added " + list[i] + ".");
            this.userMap.get(this.currentUser).add(list[i]);
        }
    }

    private void savingFiles(String username) {
        // load userMap from files and content

        FileWriter fw;
        try {
            fw = new FileWriter(username, false);
        BufferedWriter bfw = new BufferedWriter(fw);
        for (String item : this.userMap.get(this.currentUser)) {
            bfw.write(item+"\n");
        }
        System.out.println("Your cart has been saved.");
        bfw.flush();
        bfw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

}

}

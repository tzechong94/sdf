package cart;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;
// import java.util.regex.*;
public class Main {
    
    public static void main(String[] args) {

        List<String> cart = new LinkedList<>();
        Console cons = System.console();
        Boolean stop = false;
        Boolean isPresent = false;

        System.out.println("Welcome to your shopping cart");
        while (!stop) {
            // add <item>
            // list
            // delete <num>
            //exit
            String line = cons.readLine("> ");
            line = line.trim().toLowerCase();
            String[] terms = line.split("[\\s,]+");
            switch(terms[0]) {
                case "add":
                    for (Integer i = 1; i<terms.length; i++) {
                        if (cart.size() == 0) {
                            cart.add(terms[i]);
                            System.out.printf("You added %s into your cart\n", terms[i]);      
                        } else {
                            for (Integer j = 0; j < cart.size(); j++) {
                                if (terms[i].equals(cart.get(j))) {
                                    System.out.printf("You already have %s in your cart\n", cart.get(j));
                                    isPresent = true;
                                    break;
                                }
                            }
                            if (isPresent.equals(false)) {
                                cart.add(terms[i]);
                                System.out.printf("You added %s into your cart\n", terms[i]);      
                                isPresent = false;
                            } else {
                                isPresent = false;
                            }
                        }   
                    }
                    break;
                
                case "list":
                    System.out.println("The contents of your cart:");
                    for (Integer i = 0; i < cart.size(); i++){
                        System.out.printf("%d. %s\n", i+1, cart.get(i));
                    }
                    break;

                case "delete":
                    try {
                        if (Integer.parseInt(terms[1]) <= cart.size()) {
                            System.out.printf("Deleting %s\n", terms[1]);
                            cart.remove(Integer.parseInt(terms[1])-1);    
                        } else {
                            System.err.println("Incorrect item index");
                        }
                    } catch(Exception e) {
                        System.out.println("Wrong index");
                    }
                    break;

                case "exit":
                    stop = true;
                    break;

                default:
                    System.err.printf("Unknown command %s\n", terms[0]);

            }
        }
        System.out.println("Bye bye!");

    }
}
package myapp.ver1;

import java.io.Console;

public class Hello {
    public static void main(String[] args){
        // Get console
        Console cons = System.console();
        String name = "";
        while (name.trim().length() <= 0) {
            name = cons.readLine("What is your name? \n");
        }
        //Read from the console, the result is assigned to the variable name
        //Send a greeting
        System.out.printf("Hello, %s. Nice to meet you.\n", name);
       
        // to compare string, use name.equals("fred") instead of ==. == is for numbers
        String hobby = cons.readLine("What is your hobby?\n");
        switch(hobby.trim().toLowerCase()) {
            case "swim": 
                System.out.println("How fast can you swim a 100m?");
                break;

            case "jog": 
                System.out.println("How fast can you jog a kilometer?");
                break;

            case "code": 
                System.out.println("Nerd!");
                break;

            default:
                System.out.printf("What is %s? \n", hobby);
        }
    }

}

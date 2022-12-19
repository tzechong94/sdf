package myapp.exercises;

import java.io.Console;

public class TotalNumber {
    
    public static void main(String[] args){
        Console cons = System.console();
        String numInput = "";
        Integer totalNumber = 0;
        Integer count = 0;

        while (!numInput.trim().toLowerCase().equals("stop")) {
            numInput = cons.readLine("Enter a number: ");
            try {
                totalNumber += Integer.parseInt(numInput);
                count++;
            } catch (NumberFormatException e) {
                if (!numInput.trim().toLowerCase().equals("stop"))
                System.out.println("Input is not an int value, try again."); 
            }
    }
        System.out.printf("The total of the %s numbers is %s.\n", count, totalNumber);
    }
}

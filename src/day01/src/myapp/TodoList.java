package myapp;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class TodoList {

    public static void main(String[] args) {

        // create a list of numbers
        List<Integer> listOfInt = new LinkedList<>();

        //get the console
        Console cons = System.console();

        String item = "";

        while (true) {
            item = cons.readLine("Please enter a number: ");
            item = item.trim();

            if (item.equals("stop")){
                break;
            }
            listOfInt.add(Integer.parseInt(item));
        }
        System.out.printf("number of elements in the list: %d\n", listOfInt.size());
        for (Integer index = 0; index < listOfInt.size(); index++) {
            System.out.printf("[%d]: %s\n", index+1, listOfInt.get(index));
        }
    }
}

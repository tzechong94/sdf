import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        System.out.println("array List Demo");

        //create an ArrayList object
        ArrayList<String> myList = new ArrayList<String>();

        //add items to it
        myList.add("apples");
        myList.add("oranges");

        // Loop over and print the items

        for (String item : myList) {
            System.out.println("Item -> " + item);
        }

        // remove "apples" from this list
        myList.remove("apples");

        // print the no of item inside the list
        int count = myList.size();
        System.out.println(count);
    }
}
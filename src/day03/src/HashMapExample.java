import java.util.ArrayList;
import java.util.HashMap;

public class HashMapExample {
    
    public static void main(String[] args){

        //Key / Value type
        // String, Integer

        //HashMap<String, Integer> myMap = new HashMap<String, Integer>();

        HashMap<String, ArrayList<String>> myUserMap = new HashMap<String, ArrayList<String>>();

        // add a key, value pair to it 
        myUserMap.put("bala", new ArrayList<String>());
        myUserMap.put("ken", new ArrayList<String>());
        myUserMap.put("fred", new ArrayList<String>());


        String key = "bala";

        System.out.println("Value for key = " + key + " -> " + myUserMap.get(key));
        //myUserMap.put("bala", 31);
        System.out.println("Value for key = " + key + " -> " + myUserMap.get(key));

        // Check if a key exists in map
        System.out.println("Check if fred exists: " + myUserMap.containsKey("fred"));
    
    
    
    }
}

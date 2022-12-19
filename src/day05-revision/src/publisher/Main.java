package publisher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    
    public static List<List<String>> list = new ArrayList<List<String>>();

    public static List<String> lineList = new ArrayList<String>();
    String eol = System.getProperty("line.separator");

    public static void main(String[] args) {

    

        String fileName = args[0];
        ReadFile(fileName);

        Comparator<List<String>> comp = new Comparator<List<String>>() {
            public int compare(List<String> line1, List<String> line2) {
                return Integer.valueOf(line1.get(11).compareTo(String.valueOf(line2.get(11))));
            }
        };

        Collections.sort(list, comp);
        for (Integer i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get(1));
            SaveFile(list.get(i).get(11), list.get(i).get(1));;

        }

    }

    public static void ReadFile(String fileName) {

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            //List<String[]>
            String line;
            int k = 0;

            while ((line = br.readLine()) != null) {
                if (k==0){
                    k++;
                    continue;
                }
                lineList = Arrays.asList(line.split(","));
                list.add(lineList);
            }

            br.close();
            // System.out.println(list);
        } catch (IOException e) {
            System.out.printf("error %s", e.getMessage());
        } 
    }


    public static void SaveFile(String fileName, String bookName) {
        // check publisher. if exists, save to folder in a csv file.

        try {

            FileWriter fw = new FileWriter("Books/" + fileName + ".csv", true);
            BufferedWriter bfw = new BufferedWriter(fw);
            File dir = new File("Books/" + fileName + ".csv");

            if (!dir.exists()) {
                dir.mkdirs();
                bfw.write(bookName+"\n");
            } else {
                bfw.write(bookName+"\n");
            }
            bfw.close();

        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

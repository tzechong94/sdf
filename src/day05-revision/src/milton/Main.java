package milton;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {
    public static final String HEADER = "word, count\n";

    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        System.out.println("Processing " + fileName);
        String line = "";
        Integer wordCount = 0;

        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        // open the file
        Map<String, Integer> wordMap = new HashMap<>();
        String eol = System.getProperty("line.separator");
        for (Integer i = 0; i < 100; i++) {
            try {
                line = bf.readLine();
                if (null == line) {
                    bf.close();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(line);
            List<String[]> dataLines = new ArrayList<>();
            dataLines.add(new String[] 
            {
                "word",
                "count"
            });
            String[] words = line.toLowerCase().trim().split("[\\p{Punct}]|\\s");
            for (String item : words) {
                // Integer v = wordMap.getOrDefault(item, 0)
                // v++
                //wordMap.put(item, v);
                
                if (!wordMap.containsKey(item)) {
                    wordMap.put(item, 1);
                } else {
                    wordMap.put(item, wordMap.get(item) + 1);
                }
            }
            wordCount += words.length;
        }
        bf.close();
        Set<String> uniqueWords = wordMap.keySet();
        System.out.printf("Number of unique words: %d\n ", uniqueWords.size());

        for (String w: uniqueWords) {
            System.out.printf("> %s: %d\n", w, wordMap.get(w));
        }

        System.out.println(wordCount + " - Word count");

        // Writer writer = new FileWriter(csvOutputFile);
        // writer.append("word, count" + eol);
        // for (String word: wordMap.keySet()) {
        //     writer.append(word);
        //     writer.append(",");
        //     writer.append(wordMap.get(word).toString());
        //     writer.append(eol);
        // }
        // writer.close();

        FileOutputStream fos = new FileOutputStream(args[1]);
        OutputStreamWriter osw = new OutputStreamWriter(fos);

        osw.write(HEADER);
        for (String w : wordMap.keySet()) {
            String line1 = String.format("%s, %d, %s", w, wordMap.get(w), eol);
            osw.write(line1);
        }
        osw.flush();
        osw.close();

        
        // words.csv
        // first line: word, count. 
    }   
}
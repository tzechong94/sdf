package rating;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {
    
    
    public static List<List<String>> fileList = new ArrayList<List<String>>();
    public static List<String> lineList = new ArrayList<String>();
    String eol = System.getProperty("line.separator");

    public static void main(String[] args) throws Exception {
        // rating.Main filename

        String fileName = args[0];

        ReadFile(fileName);
        // System.out.println(Double.parseDouble(fileList.get(5).get(2)));

        // GetAverageRating(fileList);

        // model answer



    }


    // read file and create list of the file
    
    public static void ReadFile(String fileName) throws Exception{

        //Teacher's Answer
        // Reader r = new FileReader("googleplaystore.csv");
        // BufferedReader br = new BufferedReader(r);

        // List<App> apps = br.lines()
        //     .skip(1)
        //     .map(l -> l.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"))
        //     .filter(cols -> cols.length <= 14)
        //     .filter(cols -> !cols[2].trim().toLowerCase().equals("nan"))
        //     .map(cols -> {
        //         App app = new App();
        //         app.setName(cols[0]);
        //         app.setGenre(cols[9]);
        //         app.setRating(Float.parseFloat(cols[2]));
        //         return app;
        //     })
        //     .collect(Collectors.toList());

        // br.close();
        // r.close();

        // Map<String, List<App>> groupByGenre = apps.stream() 
        //     .collect(
        //         Collectors.groupingBy(app -> app.getGenre())
        //     );

        // for (String c : groupByGenre.keySet()) {
        //     List<App> listOfApps = groupByGenre.get(c);
        //     System.out.printf("Categories: %s - %d\n", c, listOfApps.size());
        // }

        // end of teacher's answer
        Map<String, ArrayList<Double>> ratingMap = new HashMap<String, ArrayList<Double>>();

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            List<App> fileList =  br.lines()
                            .skip(1)
                            .map(l -> l.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"))
                            .filter(cols -> cols.length <= 14)
                            // 2 is ratings, 9 is genre
                            .filter(cols -> !cols[2].trim().toLowerCase().equals("nan"))
                            .map(cols -> {
                                App line = new App();
                                line.setName(cols[0]);
                                line.setGenre(cols[9]);
                                line.setRating(Double.parseDouble(cols[2]));
                                return line;
                            })
                            .collect(Collectors.toList());               
                
            br.close();
            fr.close();

            int count = 0;

            for (App lineOfList : fileList){
                if (count==0) {
                    count++;
                    continue;
                }
                ratingMap.computeIfAbsent(lineOfList.getGenre(), genre -> new ArrayList<Double>()).add(lineOfList.getRating());
            }

            Map<Object, Object> averageMap = ratingMap.entrySet()
                        .stream()                                                
                        .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> GetAverage(e.getValue())
                        ));
            
            System.out.println(averageMap);

    
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static Double GetAverage(List<Double> doubleList) {
        Double sum = 0.0;
        Double average;
        for (Double element : doubleList) {
            sum += element;
        }
        average = sum/doubleList.size();
        return average;
    }
}


    //     try {
    //         File file = new File(fileName);
    //         FileReader fr = new FileReader(file);
    //         BufferedReader br = new BufferedReader(fr);

    //         String line;
    //         int k = 0;

    //         while ((line=br.readLine())!=null) {
    //             if (k==0) {
    //                 k++;
    //                 continue;
    //             }
    //             lineList = Arrays.asList(line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));
    //             fileList.add(lineList);
    //         }
    //         br.close();
    //         fr.close();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // // }
    // //return average rating of each genre
    // // example: arts, 4.5
    //     //      education, 4.2
         //     etc


    // public static void GetAverageRating(List<List<String>> fileList) {

    //     // my answer
    //     Map<String, ArrayList<Float>> ratingMap = new HashMap<String, ArrayList<Float>>();
    //     int count = 0;

    //     for (List<String> line : fileList){
    //         if (count==0) {
    //             count++;
    //             continue;
    //         }
    //         ratingMap.computeIfAbsent(line.get(9), genre -> new ArrayList<Double>()).add((Double.parseDouble(line.get(2))));
    //     }

            
    //     Map<Object, Object> averageMap = ratingMap.entrySet()
    //                                         .stream()                                                
    //                                         .collect(Collectors.toMap(
    //                                             Map.Entry::getKey,
    //                                             e -> e.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble())
    //                                         );



    //     System.out.println(averageMap);

    //     // end of my answer
    //     // teacher's answer

    //     }
    // }

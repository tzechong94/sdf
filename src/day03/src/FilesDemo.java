import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FilesDemo {

    public static void main(String[] args) {

        String filePath = "src/demo.txt";
        ReadFile(filePath);
        WriteFile("src/output.txt");
    }

    public static void ReadFile(String fname) {

        File fobj = Paths.get(fname).toFile();
        
        try {
            FileReader fr = new FileReader(fobj);
            BufferedReader bdf = new BufferedReader(fr);
            String line;
            
            while (null != (line = bdf.readLine())) {
                System.out.println("> " + line);
            }
            
            bdf.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File Not Found. Please check input file: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Unable to read line: " + e.getMessage());
        }
    
    }
    
    public static void WriteFile(String fname) {
        try {
            FileWriter fw = new FileWriter(fname, false); // append mode / write mode
            // fw.write("apple\n");
            // fw.write("orange\n");
            // fw.write("pear\n");
            BufferedWriter bfw = new BufferedWriter(fw);
            // bfw.write(fname);
            bfw.write("apple\n");
            bfw.write("orange\n");
            bfw.write("pear\n");

            bfw.flush();
            bfw.close();
        } catch (IOException e) {
            System.out.println("Unable to write line: " + e.getMessage());
        }

    }
    
    
    
}
    

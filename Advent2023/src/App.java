import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Day1.Trebuchet;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        BufferedReader reader;

        ArrayList<String> inputArray = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader("inputFiles/Day1PuzzleInput1.txt"));
            String line = reader.readLine();
            System.out.println("Reading input file...");
            while (line != null) {
                // System.out.println(line);
                inputArray.add(line);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File reading complete!");
        System.out.println("Beginning program...");

        Trebuchet.main(inputArray);

        System.out.println("Program complete!");
    }
}

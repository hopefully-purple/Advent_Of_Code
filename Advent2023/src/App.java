import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import main.Day1.TrebuchetPart1;
import main.Day1.TrebuchetPart2;
import main.Day2.CubeConundrumPart1;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        BufferedReader reader;

        ArrayList<String> inputArray = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader("inputFiles/Day2PuzzleInput2.txt"));
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

        // TrebuchetPart1.main(inputArray);
        // TrebuchetPart2.main(inputArray);
        CubeConundrumPart1.main(inputArray);

        System.out.println("Program complete!");
    }
}

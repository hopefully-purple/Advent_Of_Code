import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Day1.Trebuchet;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("inputFiles/Day1PuzzleInput1.txt"));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Trebuchet.main("input from App.main");
    }
}

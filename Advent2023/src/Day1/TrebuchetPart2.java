package Day1;

import java.util.ArrayList;

//Resources that contribute to solution:
// https://stackoverflow.com/questions/2338790/get-int-from-string-also-containing-letters-in-java
// https://stackoverflow.com/questions/16242733/sum-all-the-elements-java-arraylist

/**
 * Day 1: Trebuchet?! Part 2
 * What is the sum of all calibration values?
 * This time account for "one" = 1
 */
public class TrebuchetPart2 {
    public static void main(ArrayList<String> calibrationArray) {
        System.out.println("--TrebuchetPart2.main--");
        System.out.println("calibrationArray length: " + calibrationArray.size());

        //Create sample array
        ArrayList<String> sampleArray = new ArrayList<String>();
        sampleArray.add("two1nine");
        sampleArray.add("eightwothree");
        sampleArray.add("abcone2threexyz");
        sampleArray.add("xtwone3four");
        sampleArray.add("4nineeightseven2");
        sampleArray.add("zoneight234");
        sampleArray.add("7pqrstsixteen");
        sampleArray.add("nonumberscase");


        // Step 1: Get all calibration values
        ArrayList<Integer> values = calculateCalibrationValues(sampleArray);
        System.out.println(values);
        // Step 2: Sum up calibration values
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        // Step 3: Return final value (print)
        System.out.println(sum);
    }

    /**
     * two1nine
     * eightwothree
     * abcone2threexyz
     * xtwone3four
     * 4nineeightseven2
     * zoneight234
     * 7pqrstsixteen
     * 
     * 29, 83, 13, 24, 42, 14, 76 = 281
     * @param calArray
     */
    private static ArrayList<Integer> calculateCalibrationValues(ArrayList<String> calArray) {

        ArrayList<Integer> valuesArray = new ArrayList<>();
        for (String cal : calArray) {
            // step 0: scan string for written numbers
            getWrittenNumbers(cal);
            // step 1: parse cal, build a string of only ints
            String numbers = cal.replaceAll("[\\D]", "");
            int numLength = numbers.length();
            // step 2: if string.length is 0, move on to next string
            if (numLength == 0) {
                continue;
            }
            int value = 0;
            // step 3: if string.length is 1, convert to int, multiply by 11
            if (numLength == 1) {
                value = Integer.parseInt(numbers) * 11;
            } else if (numLength == 2) { // step 4: if string.length is 2, convert to int
                value = Integer.parseInt(numbers);
            } else { // step 5: take the first and last chars of string, put them together, convert to int
                String firstAndLast = String.format("%s%s", numbers.charAt(0), numbers.charAt(numLength - 1));
                value = Integer.parseInt(firstAndLast);
            }

            // step 6: add to valuesArray
            valuesArray.add(value);
        }

        return valuesArray;
    }

    private static void getWrittenNumbers(String s) {
        
    }

    // twentyeight = 208 = 28
    // 13twentyeight9 = 132089 = 19
    // twentyeight7 = 2087 = 27
    // sixteen5 = 165 = 15
    // 4sixteen = 416 = 46
    // onehundredseventytwo = 100702 = 172 = 12 ?
    private static String switchOnDigits(String s) {
        switch(s) {
            case "zero":
            case "hundred":
                return "0";
            case "one":
                return "1";
            case "two":
                return "2";
            case "three":
                return "3";
            case "four":
                return "4";
            case "five":
                return "5";
            case "six":
                return "6";
            case "seven":
                return "7";
            case "eight":
                return "8";
            case "nine":
                return "9";
            default:
                return "";
        }
    }
}

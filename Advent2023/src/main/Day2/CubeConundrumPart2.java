package main.Day2;

import java.util.ArrayList;
//Resources that contribute to solution:
import java.util.List;

/**
 * Day 2: Cube Conundrum part 2
 * For each game, find the minimum set of cubes that must have been present. 
 * What is the sum of the power of these sets?
 * https://adventofcode.com/2023/day/2
 */
public class CubeConundrumPart2 {
    public static void main(ArrayList<String> inputArray) {
        System.out.println("--CubeConundrum.main--");
        System.out.println("inputArray length: " + inputArray.size());
        
        //Create sample array
        ArrayList<String> sampleArray = new ArrayList<String>();
        sampleArray.add("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        sampleArray.add("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");
        sampleArray.add("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");
        sampleArray.add("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red");
        sampleArray.add("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");

        // step 1: Build List<array>
        List<List<int[]>> gameList = buildGameList(inputArray);
        // System.out.println(gameList.size() + " size of gameList");
        // System.out.println(gameList.get(1).size() + " size of game 1");
        // System.out.println(gameList.get(1).get(0).length + " game 1 round 1 length");
        // System.out.println(gameList.get(1).get(0)[0]);
        // System.out.println(gameList.get(1).get(0)[1]);
        // System.out.println(gameList.get(1).get(0)[2]);

        // step 3: call gameAnalyzer
        List<int[]> minimumGamesCount = gameAnalyzer(gameList);
        // System.out.println(minimumGamesCount.size() + " size of minimumGamesCount");

        // step 4: get the power of each set and sum
        int sum = 0;
        for (int[] minCount : minimumGamesCount) {
            int power = 1;
            for (int i = 0; i < 3; i++) {
                power *= minCount[i];
            }
            // System.out.println(power);
            sum += power;
        }

        // Final answer:
        System.out.println(sum);
    }

    private static List<int[]> gameAnalyzer(List<List<int[]>> gameList) {
        List<int[]> minimumCountsEachGame = new ArrayList<>();

        // Idea 1: start with a minCount array to compare to
        // if a color is > current val, replace
        // then store minCount array

        for (List<int[]> game : gameList) {
            if (game == null) {
                continue;
            }
            int [] minimumCounts = new int[3];
            for (int[] round : game) {
                for (int i = 0; i < 3; i++) {
                    if (round[i] > minimumCounts[i]) {
                        minimumCounts[i] = round[i];
                    }
                }
            }

            minimumCountsEachGame.add(minimumCounts);
        }

        return minimumCountsEachGame;
    }

    private static List<List<int[]>> buildGameList(ArrayList<String> inputArray){
        List<List<int[]>> gameList = new ArrayList<>();
        gameList.add(null); // Fill [0] with null to ensure game id to index consistency
        // System.out.print(gameList.get(0));
        for (String game : inputArray) {
            List<int[]> gameRounds = new ArrayList<>();
            // substring to remove 'Game ##: '
            int colonIndex = game.indexOf(":");
            String trimmedGame = game.substring(colonIndex);
            String[] gameSplit = trimmedGame.split(";");
            
            for (String s : gameSplit) {
                int[] round = new int[3];
                // System.out.println("S: " + s);
                String[] splitS = s.split(",");

                for (String cube : splitS) {
                    // System.out.println("CUBE: " + cube);
                    if (cube.contains("red")) {
                        int number = Integer.parseInt(cube.replaceAll("[\\D]", ""));
                        // System.out.println(number + " red");
                        round[0] = number;
                    } else if (cube.contains("green")) {
                        int number = Integer.parseInt(cube.replaceAll("[\\D]", ""));
                        // System.out.println(number + " green");
                        round[1] = number;
                    } else if (cube.contains("blue")) {
                        int number = Integer.parseInt(cube.replaceAll("[\\D]", ""));
                        // System.out.println(number + " blue");
                        round[2] = number;
                    }
                }
                // System.out.println("-----");
                // System.out.println(round[0]);
                // System.out.println(round[1]);
                // System.out.println(round[2]);
                // System.out.println("-----");
                gameRounds.add(round);
            }
            gameList.add(gameRounds);
        }

        return gameList;
    }
}

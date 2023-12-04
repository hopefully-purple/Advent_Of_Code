package main.Day2;

import java.util.ArrayList;
//Resources that contribute to solution:
import java.util.List;

/**
 * Day 2: Cube Conundrum
 * Determine which games would have been possible if the bag had been loaded with only 
 * 12 red cubes, 13 green cubes, and 14 blue cubes. 
 * What is the sum of the IDs of those games?
 * https://adventofcode.com/2023/day/2
 */
public class CubeConundrumPart1 {
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
        List<List<int[]>> gameList = buildGameList(sampleArray);
        // System.out.println(gameList.size() + " size of gameList");
        // System.out.println(gameList.get(1).size() + " size of game 1");
        // System.out.println(gameList.get(1).get(0).length + " game 1 round 1 length");
        // System.out.println(gameList.get(1).get(0)[0]);
        // System.out.println(gameList.get(1).get(0)[1]);
        // System.out.println(gameList.get(1).get(0)[2]);

        // step 2: Initialize cube amount array
        int[] officialCubeCount = new int[]{12, 13, 14};

        // step 3: call gameAnalyzer
        List<Integer> possibleGames = gameAnalyzer(gameList, officialCubeCount);
        System.out.println(possibleGames);

        // step 4: sum the ids
        int sum = 0;
        for (Integer id : possibleGames) {
            sum += id;
        }

        // Final answer:
        System.out.println(sum);
    }

    private static List<Integer> gameAnalyzer(List<List<int[]>> gameList, int[] officialCubeCount) {
        List<Integer> possibleGames = new ArrayList<>();

        // Idea 1: assume this doesn't have anything to do with probability
        // and just straight up check for numbers greater than the counts?

        for (List<int[]> game : gameList) {
            if (game == null) {
                continue;
            }
            boolean isGamePossible = true;
            for (int[] round : game) {
                for (int i = 0; i < 3; i++) {
                    if (round[i] > officialCubeCount[i]) {
                        isGamePossible = false;
                        break;
                    }
                }
            }

            if (isGamePossible) {
                int id = gameList.indexOf(game);
                possibleGames.add(id);
            }
        }

        return possibleGames;
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
                int[] round = new int[]{0,0,0};
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

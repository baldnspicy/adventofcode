package com.baldnspicy.adventofcode.aoc2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day2 {

    public static void main(String[] args) {
        List<String> inputStrings;
        String day = "2";

        inputStrings = getStringList("2023", day);

        partOne(inputStrings);
        partTwo(inputStrings);
    }

    static void partOne(List<String> strs) {
        int sum[] = new int[2];
        for (String line : strs) {
            int[] temp = getPicks(line, 12, 13, 14);
            sum[0] += temp[0];
        }
        System.out.println(sum[0]);
    }

    static void partTwo(List<String> strs) {
        int sum[] = new int[2];
        for (String line : strs) {
            int[] temp = getPicks(line, 12, 13, 14);
            sum[1] += temp[1];
        }
        System.out.println(sum[1]);
    }

    static int[] getPicks(String line, int red, int green, int blue) {
        ArrayList<ArrayList<Integer>> picks = new ArrayList<>();
        int index = 0;
        boolean underLimit = true;
        int totalOfGames = 0;
        Map<String, Integer> minColors = new HashMap<> ();
        minColors.put("red", 0);
        minColors.put("green", 0);
        minColors.put("blue", 0);

        int[] game = new int[2];
        String pickString = "";

        game[0] = Integer.parseInt(line.substring(index, line.indexOf(":")).replace("Game ", ""));
        String[] picksString = line.substring(line.indexOf(":") + 1).split(";");

        for (String pickStr : picksString) {
            String[] colors = pickStr.trim().split(",");
            for (String color : colors) {
                String[] colorAndNumber = color.trim().split(" ");
                switch (colorAndNumber[1]) {
                    case "red" -> {
                        if (Integer.parseInt(colorAndNumber[0]) > minColors.get("red")) {
                            minColors.put("red", Integer.parseInt(colorAndNumber[0]));
                        }
                        if (Integer.parseInt(colorAndNumber[0]) > red) {
                            underLimit = false;
                        }
                    }
                    case "green" -> {
                        if (Integer.parseInt(colorAndNumber[0]) > minColors.get("green")) {
                            minColors.put("green", Integer.parseInt(colorAndNumber[0]));
                        }
                        if (Integer.parseInt(colorAndNumber[0]) > green) {
                            underLimit = false;
                        }
                    }
                    case "blue" -> {
                        if (Integer.parseInt(colorAndNumber[0]) > minColors.get("blue")) {
                            minColors.put("blue", Integer.parseInt(colorAndNumber[0]));
                        }
                        if (Integer.parseInt(colorAndNumber[0]) > blue) {
                            underLimit = false;
                        }
                    }
                }
            }
        }
        game[1] = minColors.get("red") * minColors.get("green") * minColors.get("blue");
        return game;
    }
}


package com.baldnspicy.adventofcode.aoc2022;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day2 {

    public static void main(String[] args) {
        List<String> inputStrings;
        String day = "2";

        inputStrings = getStringList("2022", day);

        partOne(inputStrings);
        partTwo(inputStrings);
    }

    static void partOne(List<String> strs) {
        int ROCK = 1;
        int PAPER = 2;
        int SCISSOR = 3;
        int LOSS = 0;
        int TIE = 3;
        int WIN = 6;
        Map<String, Integer> possibleValues = new HashMap<>();
        possibleValues.put("A X", ROCK + TIE);
        possibleValues.put("A Y", PAPER + WIN);
        possibleValues.put("A Z", SCISSOR + LOSS);
        possibleValues.put("B X", ROCK + LOSS);
        possibleValues.put("B Y", PAPER + TIE);
        possibleValues.put("B Z", SCISSOR + WIN);
        possibleValues.put("C X", ROCK + WIN);
        possibleValues.put("C Y", PAPER + LOSS);
        possibleValues.put("C Z", SCISSOR + TIE);

        int total = 0;
        for (String str : strs) {
            total += possibleValues.get(str);
        }
        System.out.println(total);

    }

    static void partTwo(List<String> strs) {
        int ROCK = 1;
        int PAPER = 2;
        int SCISSOR = 3;
        int LOSS = 0;
        int TIE = 3;
        int WIN = 6;
        Map<String, Integer> possibleValues = new HashMap<>();
        possibleValues.put("A X", SCISSOR + LOSS);
        possibleValues.put("A Y", ROCK + TIE);
        possibleValues.put("A Z", PAPER + WIN);
        possibleValues.put("B X", ROCK + LOSS);
        possibleValues.put("B Y", PAPER + TIE);
        possibleValues.put("B Z", SCISSOR + WIN);
        possibleValues.put("C X", PAPER + LOSS);
        possibleValues.put("C Y", SCISSOR + TIE);
        possibleValues.put("C Z", ROCK + WIN);

        int total = 0;
        for (String str : strs) {
            total += possibleValues.get(str);
        }
        System.out.println(total);
    }
}

package com.baldnspicy.adventofcode.aoc2023;

import java.util.List;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day8 {
    public static void main(String[] args) {
        List<String> inputStrings;
        String day = "8";

        inputStrings = getStringList("2023", day);

        partOne(inputStrings);
        partTwo(inputStrings);
    }

    public static void partOne(List<String> inputStrings) {
        String leftRight = inputStrings.get(0);
        StringBuilder all = new StringBuilder(leftRight);
        for (int i = 0; i < 100; i++)
            all.append(leftRight);
        String stuff = all.toString();
        System.out.println(stuff);

    }

    public static void partTwo(List<String> inputStrings) {

    }
}

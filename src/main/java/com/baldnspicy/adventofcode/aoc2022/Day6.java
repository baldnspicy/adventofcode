package com.baldnspicy.adventofcode.aoc2022;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day6 {

    public static void main(String[] args) {
        List<String> inputStrings;

        String day = "6";
        inputStrings = getStringList("2022", day);
        partOne(inputStrings.get(0));  // Answer: 1100

        String day2 = "6";
        inputStrings = getStringList("2022", day2);
        partTwo(inputStrings.get(0));  // Answer: 2421
    }

    static void partOne(String line) {
        System.out.println("*** Part 1 answer: " + findSubstring(line, 4));
    }

    static void partTwo(String line) {
        System.out.println("*** Part 2 answer: " + findSubstring(line, 14));
    }

    static int findSubstring(String line, int substringSize) {
        Set<Character> subStrChars;
        String subStr;
        for (int i = 0; i < line.length(); i++) {
            subStrChars = new HashSet<>();
            subStr = line.substring(i, i+substringSize);
            for (int j = 0; j < substringSize; j++) {
                subStrChars.add(subStr.charAt(j));
            }
            if (subStrChars.size() == substringSize) {
                return (i + substringSize);
            }
        }
        return 0;
    }

}

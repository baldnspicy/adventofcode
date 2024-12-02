package com.baldnspicy.adventofcode.aoc2023;

import java.util.List;
import java.util.Map;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day1 {

    public static void main(String[] args) {
        List<String> inputStrings;
        String day = "1";

        inputStrings = getStringList("2023", day);

//        partOne(inputStrings);
        partTwo(inputStrings);
    }

    static void partOne(List<String> strs) {
        int sum = 0;
        for (String line : strs) {
            sum += getInteger(line);
        }
        System.out.println(sum);
    }

    static int getInteger(String line) {
        String nums = "";
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                nums += line.charAt(i);
//                break;
            }
        }
        if (nums.length() == 1) {
            nums += nums;
        }
        if (nums.length() > 2) {
            nums = nums.substring(0,1) + nums.substring(nums.length()-1, nums.length());
        }
        System.out.println(nums);
        return Integer.parseInt(nums);
    }

    static void partTwo(List<String> strs) {
        int sum = 0;
        for (String line : strs) {
            String newLine = replaceWordsWithNumbers(line);
            sum += getInteger(newLine);
        }
        System.out.println(sum);
    }

    static String replaceWordsWithNumbers(String line) {
        Map<String, String> wordsToNumbers = Map.of(
                "one", "1",
                "two", "2",
                "three", "3",
                "four", "4",
                "five", "5",
                "six", "6",
                "seven", "7",
                "eight", "8",
                "nine", "9"
        );
        String nums = "";
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                nums += line.charAt(i);
            } else {
                for (String word : wordsToNumbers.keySet()) {
                    try {
                        if (line.substring(i, i + word.length()).equals(word)) {
                            nums += wordsToNumbers.get(word);
                        }
                    } catch (Exception e) {
                        // do nothing
                    }
                }

            }
        }
        return nums;
    }
}

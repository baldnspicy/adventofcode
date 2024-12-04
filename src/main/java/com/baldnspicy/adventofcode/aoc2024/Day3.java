package com.baldnspicy.adventofcode.aoc2024;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day3 {
    static List<String> inputStrings;

    public static void main(String[] args) {
        String day = "3";

        inputStrings = getStringList("2024", day);

        partOne();  // 163931492
        partTwo();  // 76911921
    }

    private static void partOne() {
        int totalCount = 0;
        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)");
        for (String line : inputStrings) {

            Matcher matcher = pattern.matcher(line);


            // Finding matches
            while (matcher.find()) {
                totalCount += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
                System.out.println("Found: " + matcher.group() +
                        " with parameters: " + matcher.group(1) +
                        " and " + matcher.group(2) +
                        " at index: " + matcher.start());
            }
        }
        System.out.println("Total Count: " + totalCount);
    }

    private static void partTwo() {
        int totalCount = 0;
        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)|do\\(\\)|don['’]t\\(\\)");

        boolean doit = true;
        for (String line : inputStrings) {

            Matcher matcher = pattern.matcher(line);


            // Finding matches
            while (matcher.find()) {
                if (matcher.group().equals("do()")) {
                    doit = true;
                } else if (matcher.group().equals("don't()")) {
                    doit = false;
                } else if (doit) {
                    totalCount += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
                    System.out.println("Found: " + matcher.group() +
                            " with parameters: " + matcher.group(1) +
                            " and " + matcher.group(2) +
                            " at index: " + matcher.start());
                }
            }
        }
        System.out.println("Total Count: " + totalCount);
    }
}

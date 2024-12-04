package com.baldnspicy.adventofcode.aoc2024;

import java.util.ArrayList;
import java.util.List;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day2 {
    static List<String> inputStrings;
    static List<String> failedLines = new ArrayList<>();

    public static void main(String[] args) {
        String day = "2";

        inputStrings = getStringList("2024", day);

        partOne();  // 472
        partTwo();  // 520
    }

    public static void partOne() {
        int safeCount = 0;

        for (String s : inputStrings) {
            ArrayList<Integer> lineNumbers = new ArrayList<>();
            String[] numbers = s.split(" ");
            for (String s1 : numbers) {
                lineNumbers.add(Integer.parseInt(s1));
            }
            boolean increasing = lineNumbers.get(0) < lineNumbers.get(1);
            boolean safe = true;
            for (int i = 0; i < lineNumbers.size()-1; i++) {
                int left = lineNumbers.get(i);
                int right = lineNumbers.get((i + 1));
                if(!isPairSafe(left, right, increasing)) {
                    safe = false;
//                    System.out.println("Unsafe line: " + lineNumbers + " at left: " + left + " right: " + right);
                    break;
                }
            }
            if (safe) {
                safeCount++;
            }
        }
        System.out.println("Part 1: " + safeCount);
    }

    public static void partTwo() {
        int safeCount = 0;

        // do initial check of lines that are safe without removing any numbers
        for (String s : inputStrings) {
            ArrayList<Integer> lineNumbers = new ArrayList<>();
            String[] numbers = s.split(" ");
            for (String s1 : numbers) {
                lineNumbers.add(Integer.parseInt(s1));
            }
            boolean safe = checkLine(lineNumbers);
            if (safe) {
                safeCount++;
            } else {
                failedLines.add(s);
                System.out.println("Unsafe line: " + lineNumbers);
            }
        }
        System.out.println("Part 2 good ones: " + safeCount);

        // now check the failed lines
        for (String failedLine : failedLines) {
            ArrayList<Integer> lineNumbers = new ArrayList<>();
            String[] numbers = failedLine.split(" ");
            for (String s1 : numbers) {
                lineNumbers.add(Integer.parseInt(s1));
            }
            boolean safe = true;

            // now remove one number and check again
            for (int i = 0; i < lineNumbers.size(); i++) {
                ArrayList<Integer> lineNumbersCopy = new ArrayList<>(lineNumbers);
                lineNumbersCopy.remove(i);
                safe = checkLine(lineNumbersCopy);
                if (safe) {
                    break;
                }
            }
            if (safe) {
                safeCount++;
            }
        }
        System.out.println("Part 2 good ones final count: " + safeCount);
    }


    static boolean isPairSafe(int left, int right, boolean increasing) {
        int difference;
        if (increasing) {
            difference = right - left;
        } else {
            difference = left - right;
        }
        return difference > 0 && difference <= 3;
    }

    static boolean checkLine(ArrayList<Integer> lineNumbers) {
        boolean increasing = lineNumbers.get(0) < lineNumbers.get(1);
        boolean safe = true;
        for (int i = 0; i < lineNumbers.size()-1; i++) {
            int left = lineNumbers.get(i);
            int right = lineNumbers.get(i + 1);
            if(!isPairSafe(left, right, increasing)) {
                safe = false;
                break;
            }
        }
        return safe;
    }
}

package com.baldnspicy.adventofcode.aoc2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day1 {

    public static void main(String[] args) {
        List<String> inputStrings;
        String day = "1";

        inputStrings = getStringList("2024", day);

        partOne(inputStrings);
        partTwo(inputStrings);
    }

    static void partOne(List<String> strs) {
        ArrayList<Integer> left = new ArrayList<>(strs.size());
        ArrayList<Integer> right = new ArrayList<>(strs.size());
        for (String line : strs) {
            left.add(getInteger(line));
            right.add(getInteger(line.substring(8, line.length())));
        }

        Collections.sort(left);
        Collections.sort(right);
        int distanceTotal = 0;
        for (int i = 0; i < left.size(); i++) {
            distanceTotal += Math.abs(left.get(i) - right.get(i));
        }
        System.out.println("Answer for part 1: " + distanceTotal);
    }

    static int getInteger(String line) {
        StringBuilder nums = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                nums.append(line.charAt(i));
            } else {
                break;
            }
        }
        return Integer.parseInt(nums.toString());
    }

    static void partTwo(List<String> strs) {
        ArrayList<Integer> left = new ArrayList<>(strs.size());
        ArrayList<Integer> right = new ArrayList<>(strs.size());
        for (String line : strs) {
            left.add(getInteger(line));
            right.add(getInteger(line.substring(8, line.length())));
        }

        Collections.sort(left);
        Collections.sort(right);

        int similarityScore = 0;
        for (Integer integer : left) {
            int count = getCount(integer, right);
            similarityScore += (integer * count);
        }
        System.out.println("Answer for part 2: " + similarityScore);
    }

    static int getCount(int value, ArrayList<Integer> list) {
        int count = 0;
        for (int i : list) {
            if (i == value) {
                count++;
            }
        }
        return count;
    }
}

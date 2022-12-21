package com.baldnspicy.adventofcode.aoc2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day1 {

    public static void main(String[] args) {
        List<String> inputStrings;
        String day = "1";

        inputStrings = getStringList(day);

        partOne(inputStrings);
        partTwo(inputStrings);
    }

    private static void partOne(List<String> strs) {
        List<Integer> elves = new ArrayList<>();
        int sum = 0;
        int largest = 0;
        for (String line : strs) {
            if (Objects.equals(line, "")) {
                elves.add(sum);
                if (sum > largest) largest = sum;
                sum = 0;
                continue;
            }
            sum += Integer.parseInt(line);
        }
        if (sum > largest) largest = sum;
        elves.add(sum);  // add in last guy
        System.out.println(elves);
        System.out.println(largest);
    }

    private static void partTwo(List<String> strs) {
        List<Integer> elves = new ArrayList<>();
        int sum = 0;
        for (String line : strs) {
            if (Objects.equals(line, "")) {
                elves.add(sum);
                sum = 0;
                continue;
            }
            sum += Integer.parseInt(line);
        }
        elves.add(sum);  // add in last guy

        Collections.sort(elves);
        int len = elves.size();
        int threeElves = elves.get(len-1) + elves.get(len-2) + elves.get(len-3);
        System.out.println(elves);
        System.out.println(threeElves);
    }
}

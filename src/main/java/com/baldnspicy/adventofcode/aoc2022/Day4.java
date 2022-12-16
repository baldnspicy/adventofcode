package com.baldnspicy.adventofcode.aoc2022;

import java.util.ArrayList;
import java.util.List;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day4 {

    public static void main(String[] args) {
        List<String> inputStrings;
        setup();

        String day = "4";
        inputStrings = getStringList(day);
        partOne(inputStrings);

        String day2 = "4";
        inputStrings = getStringList(day2);
        partTwo(inputStrings);
    }

    static void setup() {

    }

    static void partOne(List<String> strings) {
        int found = 0;

        for (String line : strings) {
            List<Integer> nums = parseLines(line);

            if (nums.get(0) <= nums.get(2) && nums.get(1) >= nums.get(3)) {
                found += 1;
            } else if (nums.get(2) <= nums.get(0) && nums.get(3) >= nums.get(1)) {
                found += 1;
            }

        }
        System.out.println(found);
    }

    static void partTwo(List<String> strings) {
        int found = 0;

        for (String line : strings) {
            List<Integer> nums = parseLines(line);

            List<Integer> first = breakOutNumbers(nums.get(0), nums.get(1));
            List<Integer> second = breakOutNumbers(nums.get(2), nums.get(3));

            boolean hit = false;
            for (int number : second) {
                if (nums.get(0) == number) {
                    hit = true;
                    break;
                }
                else if (nums.get(1) == number) {
                    hit = true;
                    break;
                }
            }

            for (int number : first) {
                if (nums.get(2) == number) {
                    hit = true;
                    break;
                }
                else if (nums.get(3) == number) {
                    hit = true;
                    break;
                }
            }

            if (hit) {
                found += 1;
            }
        }
        System.out.println(found);

    }

    private static List<Integer> parseLines(String line) {
        line = line.replace(",", "-");
        String[] temp = line.split("-");
        List<Integer> nums = new ArrayList<>();
        nums.add(Integer.parseInt(temp[0]));
        nums.add(Integer.parseInt(temp[1]));
        nums.add(Integer.parseInt(temp[2]));
        nums.add(Integer.parseInt(temp[3]));
        return nums;
    }

    static List<Integer> breakOutNumbers(int start, int finish) {
        List<Integer> nums = new ArrayList<>();

        for (int i = start; i <= finish; i++) {
            nums.add(i);
        }
        return nums;
    }
}

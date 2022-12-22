package com.baldnspicy.adventofcode.aoc2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day10 {
    static List<Integer> steps = new ArrayList<>();
    static List<Integer> cycleValues = new ArrayList<>();
    static List<Integer> cycleValues2 = new ArrayList<>();
    static int register = 1;
    static int cycleCount = 0;

    public static void main(String[] args) {
        List<String> inputStrings;

        String day = "10";
        inputStrings = getStringList(day);
        partOne(inputStrings);  // Answer: 10760
        // Part 2 answer: FPGPHFGH

    }

    static void parseInput(List<String> lines) {

        for (String line : lines) {
            String[] params = line.split(" ");
            if (params[0].equalsIgnoreCase("noop"))
                steps.add(0);
            else {
                steps.add(Integer.parseInt(params[1]));
            }
        }
        System.out.println(steps);
    }

    static void partOne(List<String> lines) {
        cycleValues.add(0);  // add bogus to start at 1
        parseInput(lines);

        int result;
        int[] executions = new int[lines.size()];
        for (int i = 0; i < steps.size(); i++) {
            executions[i] = processCycle(steps.get(i));
        }

        System.out.println("*** Part 1 answer: " + getAnswer());
        System.out.println("*** Part 2 answer: ");
        getAnswer2();
    }

    static int processCycle(int cycle) {
        if (cycle == 0) {
            cycleCount++;
            checkCycleCount();
            checkCycleCount2();
        } else {
            cycleCount++;
            checkCycleCount();
            checkCycleCount2();
            cycleCount++;
            checkCycleCount();
            checkCycleCount2();
            register += cycle;
        }
        return register;
    }

    static void checkCycleCount() {
        int[] watches = new int[]{20, 60, 100, 140, 180, 220};
        if (Arrays.stream(watches).anyMatch(x -> x == cycleCount)) {
            System.out.println("Found: " + cycleCount + " register: " + register + " = " + cycleCount*register);
        }
        cycleValues.add(cycleCount * register);
    }

    static void checkCycleCount2() {
        cycleValues2.add(register);
    }

    static int getAnswer() {
        System.out.println("Signal 20: " + cycleValues.get(20));
        System.out.println("Signal 60: " + cycleValues.get(60));
        System.out.println("Signal 100: " + cycleValues.get(100));
        System.out.println("Signal 140: " + cycleValues.get(140));
        System.out.println("Signal 180: " + cycleValues.get(180));
        System.out.println("Signal 220: " + cycleValues.get(220));
        return (cycleValues.get(20) +
                cycleValues.get(60) +
                cycleValues.get(100) +
                cycleValues.get(140) +
                cycleValues.get(180) +
                cycleValues.get(220));
    }

    static void getAnswer2() {
        String answer = "";
        for (int i = 0; i < 241; i++) {
            final int temp = i%40;
            if (temp == 0) {
                System.out.println(answer);
                answer = "";
            }
            if (temp == cycleValues2.get(i) ||
                    temp == cycleValues2.get(i) - 1 ||
                    temp == cycleValues2.get(i) + 1) {
                answer += "#";
            } else {
                answer += ".";
            }
        }
    }
}

package com.baldnspicy.adventofcode.aoc2023;

import java.util.ArrayList;
import java.util.List;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day6 {

    public static void main(String[] args) {
        List<String> inputStrings;
        String day = "6";

        inputStrings = getStringList("2023", day);

        partOne(inputStrings);
        partTwo(inputStrings);
    }

    public static void partOne(List<String> inputStrings) {
//        List<Integer> times = getTimes(inputStrings.get(0));
//        List<Integer> winners = getTimes(inputStrings.get(1));
        int winner = getWinners(null, null);
    }

    public static List<Integer> getTimes(String time) {
        String[] times = time.split(" ");
        List<Integer> timesArray = new ArrayList<>();
        for (int i = 1; i < times.length; i++) {
            if (time.trim().length() > 0) {
                timesArray.add(Integer.parseInt(times[i]));
            }
        }

        return timesArray;
    }

    public static int getWinners(List<Integer> times, List<Integer> winners) {
        int count = 0;
        int time = 34908986;
        long winner = 204171312101780L;



            for (int j = 1; j < time; j++) {
                if ((long) j * (time - j) > winner)
                    count++;
            }
        System.out.println(count);
        return 1;

    }

    public static void partTwo(List<String> inputStrings) {

    }
}

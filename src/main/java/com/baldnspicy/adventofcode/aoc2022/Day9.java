package com.baldnspicy.adventofcode.aoc2022;

import java.util.Arrays;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Objects;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;
import static java.lang.Math.abs;

public class Day9 {
    private static final int gridSize = 1000;
    private static final String[][] grid = new String[gridSize][gridSize];
    private static SimpleEntry<String, Integer>[] steps;
    private static int HEAD_X;
    private static int HEAD_Y;
    private static int TAIL_X;
    private static int TAIL_Y;
    private static int PREV_X;
    private static int PREV_Y;


    public static void main(String[] args) {
        List<String> inputStrings;

        String day = "9";
        inputStrings = getStringList(day);
        partOne(inputStrings);  // Answer: 5960

        String day2 = "9";
        inputStrings = getStringList(day2);
//        partTwo(inputStrings);  // Answer:
    }

    static void parseInput(List<String> lines) {
        HEAD_X = HEAD_Y = TAIL_X = TAIL_Y = PREV_X = PREV_Y = gridSize/2;
//        HEAD_X = TAIL_X = PREV_X = 0;
//        HEAD_Y = TAIL_Y = PREV_Y = 5;
        steps = new SimpleEntry[lines.size()];
        int i = 0;
        for (String line : lines) {
            String[] params = line.split(" ");
            steps[i] = new SimpleEntry<>(params[0], Integer.parseInt(params[1]));
            i++;
        }
        System.out.println(Arrays.toString(steps));
    }

    static void partOne(List<String> lines) {
        parseInput(lines);

        System.out.println("*** Part 1 answer: " + doPartOneSteps());
    }

    static void partTwo(List<String> lines) {
        parseInput(lines);

//        System.out.println("*** Part 2 answer: " + getScenicViewScore());
    }

    /** Part 1 */
    static int doPartOneSteps() {
        String[][] gridAnswer = new String[gridSize][gridSize];
        gridAnswer[TAIL_Y][TAIL_X] = "X";  // set start point in answer

        for (SimpleEntry<String, Integer> step : steps) {
            doStep(step.getKey().toString(), step.getValue(), gridAnswer);
        }

        return getAnswer(gridAnswer);
    }

    static void doStep(String direction, int moves, String[][] gridAnswer) {
        for (int i = 0; i < moves; i++) {
            PREV_X = HEAD_X;
            PREV_Y = HEAD_Y;
            switch (direction) {
                case "U" -> doMove(-1, 0, gridAnswer);
                case "D" -> doMove(1, 0, gridAnswer);
                case "L" -> doMove(0, -1, gridAnswer);
                case "R" -> doMove(0, 1, gridAnswer);
            }
        }
    }

    static void doMove(int y, int x, String[][] gridAnswer) {
        HEAD_X += x;
        HEAD_Y += y;
        if ((abs(HEAD_X - TAIL_X) > 1 || abs(HEAD_Y - TAIL_Y) > 1) && (abs(HEAD_X - TAIL_X) == 1 || abs(HEAD_Y - TAIL_Y) == 1)) {
            TAIL_X = PREV_X;
            TAIL_Y = PREV_Y;
        } else {
            if (abs(HEAD_X - TAIL_X) > 1) {
                TAIL_X += x;
            }
            if (abs(HEAD_Y - TAIL_Y) > 1) {
                TAIL_Y += y;
            }
        }
        gridAnswer[TAIL_Y][TAIL_X] = "X";
    }

    static int getAnswer(String[][] gridAnswer) {
        int answer = 0;
        for (int y = 0; y < gridAnswer.length; y++) {
            for (int x = 0; x < gridAnswer.length; x++) {
                if (Objects.equals(gridAnswer[y][x], "X")) {
                    answer += 1;
                }
            }

        }
        return answer;
    }

}

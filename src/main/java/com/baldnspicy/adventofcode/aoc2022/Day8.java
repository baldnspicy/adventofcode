package com.baldnspicy.adventofcode.aoc2022;

import java.util.List;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day8 {
    private static int[][] allTrees;
    private static int width;
    private static int height;

    public static void main(String[] args) {
        List<String> inputStrings;

        String day = "8";
        inputStrings = getStringList("2022", day);
        partOne(inputStrings);  // Answer: 1794

        String day2 = "8";
        inputStrings = getStringList("2022", day2);
        partTwo(inputStrings);  // Answer: 199272
    }

    static void parseInput(List<String> lines) {
        allTrees = new int[lines.size()][lines.size()];

        int y = -1;
        for (String line : lines) {
            y++;
            for (int x = 0; x < line.length(); x++) {
                allTrees[y][x] = Integer.parseInt(String.valueOf(line.charAt(x)));
            }
        }
        width = height = y;
    }

    static void partOne(List<String> lines) {
        parseInput(lines);

        System.out.println("*** Part 1 answer: " + parseList());
    }

    static void partTwo(List<String> lines) {
        parseInput(lines);

        System.out.println("*** Part 2 answer: " + getScenicViewScore());
    }

    static int parseList() {
        int count = 0;
        for (int y = 1; y < width; y++) {
            for (int x = 1; x < height; x++) {

                if (findTallest(y, x)) {
                    count++;
                }
            }
        }
        return count + (width+1)*2 + ((width+1-2) * 2);
    }

    static boolean findTallest(int y, int x) {
        int target = allTrees[y][x];

        boolean visible_up = true;
        boolean visible_left = true;
        boolean visible_right = true;
        boolean visible_down = true;
        // up
        for (int i = y-1; i >= 0; i--) {
            if (allTrees[i][x] >= target) {
                visible_up = false;
                break;
            }
        }
        // left
        for (int i = x-1; i >= 0; i--) {
            if (allTrees[y][i] >= target) {
                visible_left = false;
                break;
            }
        }
        // right
        for (int i = x+1; i <= width; i++) {
            if (allTrees[y][i] >= target) {
                visible_right = false;
                break;
            }
        }
        // down
        for (int i = y+1; i <= height; i++) {
            if (allTrees[i][x] >= target) {
                visible_down = false;
                break;
            }
        }
        return (visible_up || visible_left || visible_right || visible_down);
    }

    /** part 2 */
    static int getScenicViewScore() {
        int score;
        int maxScore = 0;
        for (int y = 1; y < width; y++) {
            for (int x = 1; x < height; x++) {
                score = findScenicScore(y, x);
                if (score > maxScore) {
                    maxScore = score;
                }
            }
        }
        return maxScore;
    }

    static int findScenicScore(int y, int x) {
        int target = allTrees[y][x];

        int score_up = 0;
        int score_left = 0;
        int score_right = 0;
        int score_down = 0;

        // up
        for (int i = y-1; i >= 0; i--) {
            score_up++;
            if (allTrees[i][x] >= target) {
                break;
            }
        }
        // left
        for (int i = x-1; i >= 0; i--) {
            score_left++;
            if (allTrees[y][i] >= target) {
                break;
            }
        }
        // right
        for (int i = x+1; i <= width; i++) {
            score_right++;
            if (allTrees[y][i] >= target) {
                break;
            }
        }
        // down
        for (int i = y+1; i <= height; i++) {
            score_down++;
            if (allTrees[i][x] >= target) {
                break;
            }
        }
        return (score_up * score_left * score_right * score_down);
    }
}

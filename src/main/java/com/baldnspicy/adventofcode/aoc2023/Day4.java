package com.baldnspicy.adventofcode.aoc2023;

import java.util.Arrays;
import java.util.List;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day4 {
    public static void main(String[] args) {
        List<String> inputStrings;
        String day = "4";

        inputStrings = getStringList("2023", day);

        partOne(inputStrings);
        partTwo(inputStrings);
    }

    static void partOne(List<String> strs) {
        int value = 0;
        int count = 0;
        for (String line : strs) {
            int cardValue = parse(count++, line, strs.size(), 10, 25);  // full input
//            int cardValue = parse(count++, line, strs.size(), 5, 8);  // test input
            value += getCardValue(cardValue);
        }
        System.out.println(value);
    }

    static void partTwo(List<String> strs) {
        int value = 0;
        int count = 0;
        int[] multiplier = new int[strs.size()];
        for (int i = 0; i < strs.size(); i++) {
            multiplier[i] = 1;
        }

        for (String line : strs) {
            int cardValue = parse(count++, line, strs.size(), 10, 25);  // full input
//            int cardValue = parse(count++, line, strs.size(), 5, 8);  // test input
            for (int i = 0; i < cardValue; i++) {
                multiplier[count+i] += multiplier[count-1];
            }
//            value += getCardValue(cardValue) * multiplier[count-1];
        }
        value = Arrays.stream(multiplier).sum();
        System.out.println(value);
    }

    static int getCardValue(int value) {
        int list[] = new int[100];
        list[0] = 1;
        for (int i = 1; i < 99; i++) {
            list[i] = list[i-1] * 2;
        }
        return value-1 >= 0 ? list[value-1] : 0 ;
    }

    static int parse(int lineNo, String line, int width, int winNum, int selectNum) {
        int value = 0;
        int winningNumbers[] = new int[winNum];
        int selectedNumbers[] = new int[selectNum];
        String values = line.substring(line.indexOf(":")+2);
        String winningStr = values.substring(0,values.indexOf(" | "));
        String selectedStr = values.substring(values.indexOf(" | ")+3);
        winningStr = winningStr.replace("  ", " ");
        if (winningStr.charAt(0) == ' ') {
            winningStr = winningStr.substring(1);
        }
        if (selectedStr.charAt(0) == ' ') {
            selectedStr = selectedStr.substring(1);
        }
        selectedStr = selectedStr.replace("  ", " ");
        String[] winning = winningStr.split(" ");
        String[] selected = selectedStr.split(" ");

        for (int i = 0; i < winNum; i++) {
            winningNumbers[i] = Integer.parseInt(winning[i].trim());
        }

        for (int i = 0; i < selectNum; i++) {
            selectedNumbers[i] = Integer.parseInt(selected[i].trim());
        }

        for (int i = 0; i < winNum; i++) {
            for (int j = 0; j < selectNum; j++) {
                if (winningNumbers[i] == selectedNumbers[j]) {
                    value += 1;
                }
            }
        }

        return value;
    }
}

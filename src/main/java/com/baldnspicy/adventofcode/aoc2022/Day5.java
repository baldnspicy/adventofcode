package com.baldnspicy.adventofcode.aoc2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day5 {
    static List<LinkedList> cargo;

    public static void main(String[] args) {
        List<String> inputStrings;

        String day = "5";
        inputStrings = getStringList(day);
        partOne(inputStrings);  // Answer: HBTMTBSDC

        String day2 = "5";
        inputStrings = getStringList(day2);
        partTwo(inputStrings);  // Answer: PQTJRSHWS
    }

    static void setup() {
        LinkedList<String> blank = new LinkedList<>();
        LinkedList<String> one = new LinkedList<>();
        one.add("R"); one.add("N"); one.add("P"); one.add("G");
        LinkedList<String> two = new LinkedList<>();
        two.add("T"); two.add("J"); two.add("B"); two.add("L"); two.add("C"); two.add("S"); two.add("V"); two.add("H");
        LinkedList<String> three = new LinkedList<>();
        three.add("T"); three.add("D"); three.add("B"); three.add("M"); three.add("N"); three.add("L");

        LinkedList<String> four = new LinkedList<>();
        four.add("R"); four.add("V"); four.add("P"); four.add("S"); four.add("B");
        LinkedList<String> five = new LinkedList<>();
        five.add("G"); five.add("C"); five.add("Q"); five.add("S"); five.add("W"); five.add("M"); five.add("V"); five.add("H");
        LinkedList<String> six = new LinkedList<>();
        six.add("W"); six.add("Q"); six.add("S"); six.add("C"); six.add("D"); six.add("B"); six.add("J");
        LinkedList<String> seven = new LinkedList<>();
        seven.add("F"); seven.add("Q"); seven.add("L");
        LinkedList<String> eight = new LinkedList<>();
        eight.add("W"); eight.add("M"); eight.add("H"); eight.add("T"); eight.add("D"); eight.add("L"); eight.add("F"); eight.add("V");
        LinkedList<String> nine = new LinkedList<>();
        nine.add("L"); nine.add("P"); nine.add("B"); nine.add("V"); nine.add("M"); nine.add("J"); nine.add("F");
        cargo = List.of(
                blank, one, two, three, four, five, six, seven, eight, nine
        );
    }

    static void partOne(List<String> lines) {
        setup();

        System.out.println("Begin --> " + cargo);
        int skip = 10;
        for (String line : lines) {
            if (skip-- > 0)
                continue;
            moveContainer(line);
            System.out.println(line + " --> " + cargo);
        }
        System.out.print("*** Answer for Part 1: ");
        for (LinkedList<String> col : cargo) {
            if (col.isEmpty())
                continue;
            System.out.print(col.getLast());
        }

    }

    static void partTwo(List<String> lines) {
        setup();

        System.out.println("Begin --> " + cargo);
        int skip = 10;
        for (String line : lines) {
            if (skip-- > 0)
                continue;
            moveContainers(line);
            System.out.println(line + " --> " + cargo);
        }
        System.out.print("*** Answer for Part 2: ");
        for (LinkedList<String> col : cargo) {
            if (col.isEmpty())
                continue;
            System.out.print(col.getLast());
        }
    }

    static void moveContainer(String line) {
        List<Integer> vals = parseLine(line);
        String temp;
        for (int i = 0; i < vals.get(0); i++ ) {
            temp = (String) cargo.get(vals.get(1)).getLast();
            cargo.get(vals.get(2)).add(temp);
            cargo.get(vals.get(1)).removeLast();
        }
    }

    static void moveContainers(String line) {
        List<Integer> vals = parseLine(line);
        String temp;
        List<String> newStr = new ArrayList<>();
        for (int i = 0; i < vals.get(0); i++ ) {
            temp = (String) cargo.get(vals.get(1)).getLast();
            newStr.add(temp);
            cargo.get(vals.get(1)).removeLast();
        }
        for (int i = newStr.size()-1; i >= 0; i--) {
            cargo.get(vals.get(2)).add(newStr.get(i));
        }
    }

    private static List<Integer> parseLine(String line) {
        String[] temp = line.split(" ");
        List<Integer> nums = new ArrayList<>();
        nums.add(Integer.parseInt(temp[1]));
        nums.add(Integer.parseInt(temp[3]));
        nums.add(Integer.parseInt(temp[5]));
        return nums;
    }
}

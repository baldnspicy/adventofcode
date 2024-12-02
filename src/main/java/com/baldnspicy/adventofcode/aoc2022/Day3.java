package com.baldnspicy.adventofcode.aoc2022;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Day3 {
    static Dictionary<Character, Integer> priority = new Hashtable<>();

    public static void main(String[] args) {
        List<String> inputStrings;
        setup();

        String day = "3";
        inputStrings = getStringList("2022", day);
        partOne(inputStrings);

        String day2 = "3.2";
        inputStrings = getStringList("2022", day2);
        partTwo(inputStrings);
    }

    static void partOne(List<String> strings) {
        String front;
        String back;
        int total = 0;

        int line = 0;
        for (String str : strings) {
            ++line;
            front = str.substring(0, str.length()/2);
            back = str.substring(str.length()/2);
//            System.out.println(line + ": " + str + " " + front + " - " + back);
            for (char ch : front.toCharArray()) {

                int found = back.indexOf(ch);
                if (found > -1) {
                    total += getValue(ch);
                    break;
                }

            }
        }
        System.out.println("**** " + total + " ****");
    }

    static void partTwo(List<String> strings) {
        String one;
        String two;
        String three;
        int total = 0;

        setup();
        int len = strings.size()/3;

        for (int i = 0; i < len; i++) {
            int index = i * 3;
            one = strings.get(index);
            two = strings.get(index + 1);
            three = strings.get(index + 2);
//            System.out.println(one + " " + two + " " + three);

            for (char ch : one.toCharArray()) {

                int found = two.indexOf(ch);
                if (found > -1) {
                    if (three.indexOf(ch) > -1) {
                        total += getValue(ch);
                        break;
                    }
                }

            }
        }
        System.out.println("**** " + total + " ****");
    }

    static int getValue(char ch) {
        return priority.get(ch);
    }

    static void setup() {
        priority.put('a', 1);
        priority.put('b', 2);
        priority.put('c', 3);
        priority.put('d', 4);
        priority.put('e', 5);
        priority.put('f', 6);
        priority.put('g', 7);
        priority.put('h', 8);
        priority.put('i', 9);
        priority.put('j', 10);
        priority.put('k', 11);
        priority.put('l', 12);
        priority.put('m', 13);
        priority.put('n', 14);
        priority.put('o', 15);
        priority.put('p', 16);
        priority.put('q', 17);
        priority.put('r', 18);
        priority.put('s', 19);
        priority.put('t', 20);
        priority.put('u', 21);
        priority.put('v', 22);
        priority.put('w', 23);
        priority.put('x', 24);
        priority.put('y', 25);
        priority.put('z', 26);

        priority.put('A', 27);
        priority.put('B', 28);
        priority.put('C', 29);
        priority.put('D', 30);
        priority.put('E', 31);
        priority.put('F', 32);
        priority.put('G', 33);
        priority.put('H', 34);
        priority.put('I', 35);
        priority.put('J', 36);
        priority.put('K', 37);
        priority.put('L', 38);
        priority.put('M', 39);
        priority.put('N', 40);
        priority.put('O', 41);
        priority.put('P', 42);
        priority.put('Q', 43);
        priority.put('R', 44);
        priority.put('S', 45);
        priority.put('T', 46);
        priority.put('U', 47);
        priority.put('V', 48);
        priority.put('W', 49);
        priority.put('X', 50);
        priority.put('Y', 51);
        priority.put('Z', 52);
    }
}

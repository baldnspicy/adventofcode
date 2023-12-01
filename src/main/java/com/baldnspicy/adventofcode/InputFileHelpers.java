package com.baldnspicy.adventofcode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class InputFileHelpers {

    /** Takes day as input, returns List of strings from that day's input */
    public static List<String> getStringList(String year, String day) {
        InputStream puzzleInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(year + "/day" + day);
        List<String> strings = null;
        if (puzzleInputStream == null) {
            System.err.println("Missing input data; expected to find 2022/day" + day);
        } else {
            strings = new BufferedReader(new InputStreamReader(puzzleInputStream))
                    .lines().toList();
        }
        return strings;
    }
}

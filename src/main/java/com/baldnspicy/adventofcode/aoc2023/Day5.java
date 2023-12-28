package com.baldnspicy.adventofcode.aoc2023;

import java.util.ArrayList;
import java.util.List;

import static com.baldnspicy.adventofcode.InputFileHelpers.getStringList;

public class Day5 {
    static ArrayList<Range> seedToSoilMap = new ArrayList<>();
    static ArrayList<Range>  soilToFertilizerMap = new ArrayList<>();
    static ArrayList<Range> fertilizerToWaterMap = new ArrayList<>();
    static ArrayList<Range> waterToLightMap = new ArrayList<>();
    static ArrayList<Range> lightToTemperatureMap = new ArrayList<>();
    static ArrayList<Range> temperatureToHumidityMap = new ArrayList<>();
    static ArrayList<Range> humidityToLocationMap = new ArrayList<>();

    public static void main(String[] args) {
        List<String> inputStrings;
        String day = "5";

        inputStrings = getStringList("2023", day);

        partOne(inputStrings);
        partTwo(inputStrings);
    }

    static void partOne(List<String> strs) {
        long[] seeds = loadSeeds(strs.get(0));
        strs = strs.subList(3, strs.size());


        // get the lines from the input
        List<String> lines = linesToNextSpace(strs);
        strs = strs.subList(lines.size()+2, strs.size());
        processLines(lines, seedToSoilMap);


        lines = linesToNextSpace(strs);
        strs = strs.subList(lines.size()+2, strs.size());
        processLines(lines, soilToFertilizerMap);

        lines = linesToNextSpace(strs);
        strs = strs.subList(lines.size()+2, strs.size());
        processLines(lines, fertilizerToWaterMap);

        lines = linesToNextSpace(strs);
        strs = strs.subList(lines.size()+2, strs.size());
        processLines(lines, waterToLightMap);

        lines = linesToNextSpace(strs);
        strs = strs.subList(lines.size()+2, strs.size());
        processLines(lines, lightToTemperatureMap);

        lines = linesToNextSpace(strs);
        strs = strs.subList(lines.size()+2, strs.size());
        processLines(lines, temperatureToHumidityMap);

        lines = linesToNextSpace(strs);
        processLines(lines, humidityToLocationMap);

        long lowest = Long.MAX_VALUE;
        for (long seed : seeds) {
            long temp;
            temp = getDist(humidityToLocationMap, getDist(temperatureToHumidityMap, getDist(lightToTemperatureMap, getDist(waterToLightMap, getDist(fertilizerToWaterMap, getDist(soilToFertilizerMap, getDist(seedToSoilMap, seed)))))));
            if (temp < lowest) {
                lowest = temp;
            }
        }

        System.out.println(lowest);

    }

    static long getDist(List<Range> list, long seed) {

        for (Range r : list) {
            if (r.isBetween(seed))
                return r.getDestination(seed);
            }
        return seed;

    }

    static long[] loadSeeds(String str) {
        String[] seeds = str.substring(6).trim().split(" ");
        long[] seedNums = new long[seeds.length];
        for (int i = 0; i < seedNums.length; i++) {
            seedNums[i] = Long.parseLong(seeds[i]);
        }
        return seedNums;
    }

    static List<String> linesToNextSpace(List<String> strs) {
        List<String> lines = new ArrayList<>();
        for (String line : strs) {
            line = line.trim();
            if (!line.isEmpty()) {
                lines.add(line);
            } else {
             return lines;
            }
        }
        return lines;
    }

    static void processLines(List<String> strs, List<Range> map) {
        for (String line : strs) {
            processLine(line, map);
        }
    }

    static void processLine(String line, List<Range> list) {
        String[] tokens = line.split(" ");
        long source = Long.parseLong(tokens[1]);
        long destination = Long.parseLong(tokens[0]);
        long length = Long.parseLong(tokens[2]);

        list.add(new Range(source, destination, length-1));
    }

    static void partTwo(List<String> strs) {

    }

    static class Range {
        long source;
        long end;
        long destination;

        Range(long source, long destination, long end) {
            this.source = source;
            this.destination = destination;
            this.end = end;
        }

        boolean isBetween(long number) {
            return number >= this.source && number <= this.source + this.end;
        }

        public long getDestination(long number) {
            return this.destination + (number - this.source);
        }
    }
}

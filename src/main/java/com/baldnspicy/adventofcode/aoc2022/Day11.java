package com.baldnspicy.adventofcode.aoc2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Day11 {
    private static List<Monkey> monkeys;
    private static boolean test;

    public static void main(String[] args) {
        List<String> inputStrings;

        test = false;
        setup();
        String day = "11";
        partOne(20);  // Answer:
        // Part 2 answer:

    }

    static void setup() {
        monkeys = new ArrayList<>();
        if (test) {
            Monkey monkey0 = new Monkey(new ArrayList<Integer>() {
                {
                    add(79);
                    add(98);
                }
            }, OPERATION.MULTIPLICATION, 19, 23, 2, 3);
            Monkey monkey1 = new Monkey(new ArrayList<Integer>() {
                {
                    add(54);
                    add(65);
                    add(75);
                    add(74);
                }
            }, OPERATION.ADD, 6, 19, 2, 0);
            Monkey monkey2 = new Monkey(new ArrayList<Integer>() {
                {
                    add(79);
                    add(60);
                    add(97);
                }
            }, OPERATION.MULTIPLICATION, 0, 13, 1, 3);
            Monkey monkey3 = new Monkey(new ArrayList<Integer>() {
                {
                    add(74);
                }
            }, OPERATION.ADD, 3, 17, 0, 1);
            monkeys.add(monkey0);
            monkeys.add(monkey1);
            monkeys.add(monkey2);
            monkeys.add(monkey3);
        } else {
            Monkey monkey0 = new Monkey(new ArrayList<Integer>() {
                {
                    add(72);
                    add(97);
                }
            }, OPERATION.MULTIPLICATION, 13, 19, 5, 6);
            Monkey monkey1 = new Monkey(new ArrayList<Integer>() {
                {
                    add(55);
                    add(70);
                    add(90);
                    add(74);
                    add(95);
                }
            }, OPERATION.MULTIPLICATION, 0, 7, 5, 0);
            Monkey monkey2 = new Monkey(new ArrayList<Integer>() {
                {
                    add(74);
                    add(97);
                    add(66);
                    add(57);
                }
            }, OPERATION.ADD, 6, 17, 1, 0);
            Monkey monkey3 = new Monkey(new ArrayList<Integer>() {
                {
                    add(86);
                    add(54);
                    add(53);
                }
            }, OPERATION.ADD, 2, 13, 1, 2);
            Monkey monkey4 = new Monkey(new ArrayList<Integer>() {
                {
                    add(50);
                    add(65);
                    add(78);
                    add(50);
                    add(62);
                    add(99);
                }
            }, OPERATION.ADD, 3, 11, 3, 7);
            Monkey monkey5 = new Monkey(new ArrayList<Integer>() {
                {
                    add(90);
                }
            }, OPERATION.ADD, 4, 2, 4, 6);
            Monkey monkey6 = new Monkey(new ArrayList<Integer>() {
                {
                    add(88);
                    add(92);
                    add(63);
                    add(94);
                    add(96);
                    add(82);
                    add(53);
                    add(53);
                }
            }, OPERATION.ADD, 8, 5, 4, 7);
            Monkey monkey7 = new Monkey(new ArrayList<Integer>() {
                {
                    add(70);
                    add(60);
                    add(71);
                    add(69);
                    add(77);
                    add(70);
                    add(98);
                }
            }, OPERATION.MULTIPLICATION, 7, 3, 2, 3);
            monkeys.add(monkey0);
            monkeys.add(monkey1);
            monkeys.add(monkey2);
            monkeys.add(monkey3);
            monkeys.add(monkey4);
            monkeys.add(monkey5);
            monkeys.add(monkey6);
            monkeys.add(monkey7);
        }
    }

    static void partOne(int rounds) {
        int numRounds = rounds;
        for (int i = 0; i < numRounds; i++) {
            for (Monkey monkey : monkeys) {
                processMonkey(monkey);
            }
//            System.out.println(monkeys);
        }
        System.out.println("*** Part 1 answer: " + getAnswerPartOne());
//        System.out.println("*** Part 2 answer: ");
    }

    static void processMonkey(Monkey monkey) {

        while (!monkey.getItems().isEmpty()) {
            System.out.println("Before: ");
            doDebugPrint();
            int item = monkey.getItems().get(0);
            int newWorryLevel;
            int mod;
            if (monkey.getOperation() == OPERATION.ADD) {
                newWorryLevel = monkey.getOperationValue() + item;
                newWorryLevel = lowerWorryLevel(newWorryLevel);
                mod = newWorryLevel % monkey.getDivisibleBy();
                if (mod == 0) {
                    monkeys.get(monkey.throwToTrue).getItems().add(newWorryLevel);
                } else {
                    monkeys.get(monkey.throwToFalse).getItems().add(newWorryLevel);
                }

            } else if (monkey.getOperation() == OPERATION.MULTIPLICATION) {
                if (monkey.getOperationValue() == 0)
                    newWorryLevel = item * item;
                else
                    newWorryLevel = monkey.getOperationValue() * item;
                newWorryLevel = lowerWorryLevel(newWorryLevel);
                mod = newWorryLevel % monkey.getDivisibleBy();
                if (mod == 0) {
                    monkeys.get(monkey.throwToTrue).getItems().add(newWorryLevel);
                } else {
                    monkeys.get(monkey.throwToFalse).getItems().add(newWorryLevel);
                }
            }
            monkey.getItems().remove(0);
            monkey.incrementInspection();
            System.out.println("After: ");
            doDebugPrint();
        }
    }

    static int lowerWorryLevel(int worryLevel) {
        int divideBy = 3;
        return Math.floorDiv(worryLevel, divideBy);
    }

    static void doDebugPrint() {
        for (Monkey monkey :
                monkeys) {
            System.out.println(monkey);
        }
    }

    static int getAnswerPartOne() {
        List<Integer> allCounts = new ArrayList<>();
        for (Monkey monkey :
                monkeys) {
            allCounts.add(monkey.inspectionTimes);
        }
        System.out.println(allCounts);
        Collections.sort(allCounts);
        System.out.println(allCounts);
        return allCounts.get(allCounts.size()-1) * allCounts.get(allCounts.size()-2);
    }

    static class Monkey {
        List<Integer> items;
        OPERATION operation;
        int operationValue;
        int divisibleBy;
        int throwToTrue;
        int throwToFalse;
        int inspectionTimes;

        public int getInspectionTimes() {
            return inspectionTimes;
        }

        public void setInspectionTimes(int inspectionTimes) {
            this.inspectionTimes = inspectionTimes;
        }

        public Monkey(List<Integer> items, OPERATION operation, int operationValue, int divisibleBy, int throwToTrue, int throwToFalse) {
            this.items = items;
            this.operation = operation;
            this.operationValue = operationValue;
            this.divisibleBy = divisibleBy;
            this.throwToTrue = throwToTrue;
            this.throwToFalse = throwToFalse;
            this.inspectionTimes = 0;
        }

        public List<Integer> getItems() {
            return items;
        }

        public void setItems(List<Integer> items) {
            this.items = items;
        }

        public OPERATION getOperation() {
            return operation;
        }

        public void setOperation(OPERATION operation) {
            this.operation = operation;
        }

        public int getOperationValue() {
            return operationValue;
        }

        public void setOperationValue(int operationValue) {
            this.operationValue = operationValue;
        }

        public int getDivisibleBy() {
            return divisibleBy;
        }

        public void setDivisibleBy(int divisibleBy) {
            this.divisibleBy = divisibleBy;
        }

        public int getThrowToTrue() {
            return throwToTrue;
        }

        public void setThrowToTrue(int throwToTrue) {
            this.throwToTrue = throwToTrue;
        }

        public int getThrowToFalse() {
            return throwToFalse;
        }

        public void setThrowToFalse(int throwToFalse) {
            this.throwToFalse = throwToFalse;
        }

        public void incrementInspection() {
            this.inspectionTimes++;
        }

        @Override
        public String toString() {
            return "Monkey{" +
                    "items=" + items +
                    ", inspectionTimes=" + inspectionTimes +
//                    ", operationValue=" + operationValue +
//                    ", divisibleBy=" + divisibleBy +
//                    ", throwToTrue=" + throwToTrue +
//                    ", throwToFalse=" + throwToFalse +
                    '}';
        }
    }

    enum OPERATION {
        ADD,
        SUBTRACT,
        MULTIPLICATION,
        DIVISION
    }
}

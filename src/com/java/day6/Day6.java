package com.java.day6;

import com.java.utils.Day;
import com.java.utils.PuzzleInputReader;

import java.util.ArrayList;
import java.util.List;

public class Day6 implements Day {
    List<String> input = PuzzleInputReader.getInputString("inputday6.txt");

    @Override
    public void puzzle1() {
        List<Character> yesAnswer = new ArrayList<>();
        int sum = 0;

        for (String s: input) {
            if (s.trim().isEmpty()) {
               int count = yesAnswer.size();
               sum += count;
               yesAnswer.clear();
            } else {
                for (char c: s.trim().toCharArray()) {
                    if (!yesAnswer.contains(c)) {
                        yesAnswer.add(c);
                    }
                }
            }
        }
        sum += yesAnswer.size(); // dodanie ostatniej lini
        System.out.println("Part 1. Suma odpowiedzi to :" + sum);
    }

    @Override
    public void puzzle2() {
        List<String> lines = new ArrayList<>();
        int sum = 0;

        for (String s: input) {
            if (s.trim().isEmpty()) {
                String firstLine = lines.get(0);
                for (char c: firstLine.toCharArray()) {
                    boolean check = false;
                    for(int i = 0; i <lines.size(); i++) {
                        if (lines.get(i).indexOf(c) != -1) {
                            check = true;
                        } else if (check) {
                            check = false;
                            break;
                        } else {
                            break;
                        }
                    }
                    if (check) {
                        sum++;
//                        System.out.println("========");
//                        System.out.println("Lista: " + lines.toString());
//                        System.out.println("Znak: " + c);
//                        System.out.println("========");
                    }
                }
                lines.clear();
            } else {
                lines.add(s.trim());
            }
        }
        System.out.println("Part 2. Suma odpowiedzi to :" + sum);
    }
}

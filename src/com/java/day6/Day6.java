package com.java.day6;

import com.java.utils.Day;
import com.java.utils.PuzzleInputReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        System.out.println("Part1. Suma odpowiedzi to :" + sum);
    }

    @Override
    public void puzzle2() {

    }
}

package com.java.day1;

import com.java.utils.Day;
import com.java.utils.PuzzleInputReader;

import java.util.List;

public class Day1 implements Day {
    List<Integer> input = PuzzleInputReader.getInputInt("inputday1.txt");

    @Override
    public void puzzle1() {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                if(input.get(i) + input.get(j) == 2020) {
                    System.out.println(input.get(i) * input.get(j));
                    break;
                }
            }
        }
    }

    @Override
    public void puzzle2() {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                for (int y = j +1 ; y < input.size(); y++) {
                    if(input.get(i) + input.get(j) + input.get(y) == 2020) {
                        System.out.println(input.get(i) * input.get(j) * input.get(y));
                        break;
                    }
                }
            }
        }
    }
}

package com.java.day3;

import com.java.utils.Day;
import com.java.utils.PuzzleInputReader;

import java.util.List;

public class Day3 implements Day {
    List<String> input = PuzzleInputReader.getInputString("inputday3.txt");

    @Override
    public void puzzle1() {
        System.out.println("Liczba drzew: " + countTreeForSlope(3, 1));
    }

    @Override
    public void puzzle2() {
        System.out.println("Iloczyn drzew na róznych stokach: " +
                countTreeForSlope(1, 1) *
                countTreeForSlope(3, 1) *
                countTreeForSlope(5, 1) *
                countTreeForSlope(7, 1) *
                countTreeForSlope(1, 2));
    }
    int countTreeForSlope(int right, int down) {
        int rightTemp = right;
        int countTree = 0;
        for (int i = down; i < input.size(); i += down) {
            if (input.get(i).charAt(rightTemp) == '#') {
                countTree++;
            }
            rightTemp += right;
            if(rightTemp >= 31) {
                rightTemp -= 31;
            }
        }
        return countTree;
    }
}

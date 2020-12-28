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
        List<String> listInput = getFilteredInputList();
        Set<Character> inputSet = new HashSet<>();
        int sum = 0;

        for (String row: listInput) {
            System.out.println("===========");
            System.out.println("Size: " + row.length() + " | " + row);
            for (int i = 0; i < row.length(); i++) {
                inputSet.add(row.charAt(i));
                System.out.println(row.charAt(i));
            }
            System.out.println("=======");
            System.out.println(inputSet.size());
            System.out.println(inputSet.toString());
            sum += inputSet.size();
            inputSet.clear();
        }
        System.out.println("Suma odpowiedzi: " + sum);
    }

    @Override
    public void puzzle2() {

    }
    private List<String> getFilteredInputList() {
        input.add("");
        List<String> puzzleInput = new ArrayList<>();
        StringBuilder tempString = new StringBuilder();
        for (String row: input) {
            if(row.equals("")) {
                puzzleInput.add(tempString.toString());
                tempString = new StringBuilder();
            } else {
                tempString.append(row);
            }
        }
        return puzzleInput;
    }
}

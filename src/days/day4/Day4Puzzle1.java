package days.day4;

import days.utils.PuzzleInputReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mateusz D�bek
 * @created 18 gru 2020
 */

public class Day4Puzzle1 {
    private static final String[] FIELDS = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};


    public static void main(String[] args) {
        List<String> input = PuzzleInputReader.getInputString("inputday4.txt");
        System.out.println(countValidPassport(input));
    }

    private static int countValidPassport(List<String> rawInput) {
        Map<String, String> mapInput = new HashMap<>();
        int countValid = 0;
        boolean valid = true;

        for (String s: rawInput) {
            valid = true;

            if (s.equals("")) {
                for (String field: FIELDS) {
                    if (!mapInput.containsKey(field)) {
                        valid = false;
                        break;
                    }
                }
                mapInput.clear();
            } else {
                String[] oneLine = s.split(" ");
                for (String line: oneLine) {
                    String[] oneFiled = line.split(":");
                    mapInput.put(oneFiled[0], oneFiled[1]);
                }
                valid = false;
            }
            if(valid) {
                countValid++;
            }
        }
        return countValid;
    }
}

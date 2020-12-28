package com.java.day4;

import com.java.utils.Day;
import com.java.utils.PuzzleInputReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 implements Day {
    private static final String[] FIELDS = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
    List<String> input = PuzzleInputReader.getInputString("inputday4.txt");
    Map<String, String> mapInput = new HashMap<>();

    @Override
    public void puzzle1() {
        input.add(""); // dodanie pustej lini na końcu listy tak aby pętla dobrze działała
        mapInput.clear();
        int countValid = 0;
        boolean valid;

        for (String s: input) {
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
        System.out.println("Ważnych paszportów: " + countValid);
    }

    @Override
    public void puzzle2() {
        mapInput.clear();
        int countValid = 0;
        boolean valid;

        for (String s: input) {
            if (s.equals("")) {
                try {
                    valid = validBirth(mapInput.get("byr")) &&
                            validIssue(mapInput.get("iyr")) &&
                            validExpiration(mapInput.get("eyr")) &&
                            validHeight(mapInput.get("hgt")) &&
                            validHairColor(mapInput.get("hcl")) &&
                            validEyeColor(mapInput.get("ecl")) &&
                            validPassportID(mapInput.get("pid"));
                } catch (Exception e) {
                    valid = false;
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
        System.out.println("Ważnych paszportów z wszystkimi polami: " + countValid);
    }

    private boolean validBirth(String s) {
        return s.length() == 4 && isBetween(Integer.parseInt(s), 1920, 2002);
    }

    private boolean validIssue(String s ) {
        return s.length() == 4 && isBetween(Integer.parseInt(s), 2010, 2020);
    }

    private boolean validExpiration(String s ) {
        return s.length() == 4 && isBetween(Integer.parseInt(s), 2020, 2030);
    }

    private boolean validHeight(String s ) {
        if (s.endsWith("cm")) {
            return isBetween(Integer.parseInt(s.substring(0, s.indexOf("cm"))), 150, 193);
        } else if (s.endsWith("in")) {
            return isBetween(Integer.parseInt(s.substring(0, s.indexOf("in"))), 59, 76);
        }
        return false;
    }

    private boolean validHairColor(String s ) {
        Pattern regex = Pattern.compile("#[a-f0-9]{6}");
        Matcher matcher = regex.matcher(s);

        return matcher.matches();
    }

    private boolean validEyeColor(String s ) {
        String[] colors = new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};

        for (String color: colors) {
            if (s.equals(color)) {
                return true;
            }
        }
        return false;
    }

    private boolean validPassportID(String s ) {
        Pattern regex = Pattern.compile("[0-9]{9}");
        Matcher matcher = regex.matcher(s);

        return matcher.matches();
    }

    private boolean isBetween(int value, int min, int max) {
        return value >=min && value <= max;
    }
}

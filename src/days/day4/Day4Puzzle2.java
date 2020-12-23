package days.day4;

import days.utils.PuzzleInputReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mateusz D�bek
 * @created 18 gru 2020
 */

public class Day4Puzzle2 {

    public static void main(String[] args) {
        List<String> input = PuzzleInputReader.getInputString("inputday4.txt");
        System.out.println(countValidAndPresentPassport(input));
    }

    private static int countValidAndPresentPassport(List<String> rawInput) {
        Map<String, String> mapInput = new HashMap<>();
        int countValid = 0;
        boolean valid;

        for (String s: rawInput) {
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
        return countValid;
    }

    private static boolean validBirth(String s) {
        return s.length() == 4 && isBetween(Integer.parseInt(s), 1920, 2002);
    }

    private static boolean validIssue(String s ) {
        return s.length() == 4 && isBetween(Integer.parseInt(s), 2010, 2020);
    }

    private static boolean validExpiration(String s ) {
        return s.length() == 4 && isBetween(Integer.parseInt(s), 2020, 2030);
    }

    private static boolean validHeight(String s ) {
        if (s.endsWith("cm")) {
            return isBetween(Integer.parseInt(s.substring(0, s.indexOf("cm"))), 150, 193);
        } else if (s.endsWith("in")) {
            return isBetween(Integer.parseInt(s.substring(0, s.indexOf("in"))), 59, 76);
        }
        return false;
    }

    private static boolean validHairColor(String s ) {
        Pattern regex = Pattern.compile("#[a-f0-9]{6}");
        Matcher matcher = regex.matcher(s);

        return matcher.matches();
    }

    private static boolean validEyeColor(String s ) {
        String[] colors = new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};

        for (String color: colors) {
            if (s.equals(color)) {
                return true;
            }
        }
        return false;
    }

    private static boolean validPassportID(String s ) {
        Pattern regex = Pattern.compile("[0-9]{9}");
        Matcher matcher = regex.matcher(s);

        return matcher.matches();
    }

    private static boolean isBetween(int value, int min, int max) {
        return value >=min && value <= max;
    }
}

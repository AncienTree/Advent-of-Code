package com.java.day2;

import com.java.utils.Day;
import com.java.utils.PuzzleInputReader;

import java.util.List;

public class Day2 implements Day {
    List<String> input = PuzzleInputReader.getInputString("inputday2.txt");

    @Override
    public void puzzle1() {
        int count = 0;
        for (String string : input) {
            if(isValid(string)) {
                count++;
            }
        }
        System.out.println("Poprawne hasła: " + count);
    }

    @Override
    public void puzzle2() {
        int count = 0;

        for (String string : input) {
            if(isValidNewPolicies(string)) {
                count++;
            }
        }
        System.out.println("Poprawne hasła (nowa polityka): " + count);
    }

    private boolean isValid(String password) {
        int indexOfChar = password.indexOf('-');
        int indexOfSpace = password.indexOf(' ');
        int indexOfColon = password.indexOf(':');

        boolean check = false;
        int min = Integer.parseInt(password.substring(0, indexOfChar));
        int max = Integer.parseInt(password.substring(indexOfChar + 1, indexOfSpace));
        char charCheck = password.charAt(indexOfSpace + 1);
        String pass = password.substring(indexOfColon + 2);

        int count = 0;

        for (int i = 0; i < pass.length(); i++) {
            if(pass.charAt(i) == charCheck) {
                count ++;
            }
        }
        if (count >= min && count <= max) {
            check = true;
        }
        return check;
    }
    private boolean isValidNewPolicies(String password) {
        int indexOfChar = password.indexOf('-');
        int indexOfSpace = password.indexOf(' ');
        int indexOfColon = password.indexOf(':');

        boolean check = false;
        int first = Integer.parseInt(password.substring(0, indexOfChar));
        int second = Integer.parseInt(password.substring(indexOfChar + 1, indexOfSpace));
        char charCheck = password.charAt(indexOfSpace + 1);
        String pass = password.substring(indexOfColon + 2);

        var b = pass.length() > second - 1 && pass.charAt(second - 1) == charCheck;
        if (pass.length() > first - 1 && pass.charAt(first - 1) == charCheck) {
            if (b) {
                return false;
            }
            check = true;
        } else if (b) {
            check = true;
        }

        return check;
    }
}

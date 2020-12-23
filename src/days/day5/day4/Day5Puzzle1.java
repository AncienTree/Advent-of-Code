package days.day5.day4;

import days.utils.PuzzleInputReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mateusz D�bek
 * @created 18 gru 2020
 */

public class Day5Puzzle1 {


    public static void main(String[] args) {
        List<String> input = PuzzleInputReader.getInputString("inputday5.txt");
        System.out.println(boardingPass(input));
    }

    public static int boardingPass(List<String> input) {
        int row = 0, column = 0, lh, uh, seat;
        int highestSeatID = Integer.MIN_VALUE;
        for (String boardingPass: input) {
            lh = 0;
            uh = 128;
            for (int i = 0; i < 7; i++) {
                char code = boardingPass.charAt(i);
                if (code == 'F') {
                    uh -= (uh - lh)/2;
                } else if (code == 'B') {
                    lh += (uh - lh)/2;
                }
            }
            row = uh - 1;

            lh = 0;
            uh = 8;
            for (int i = 7; i < boardingPass.length(); i++) {
                char code = boardingPass.charAt(i);
                if (code == 'L') {
                    uh -= (uh - lh)/2;
                } else if (code == 'R') {
                    lh += (uh - lh)/2;
                }
            }
            column = uh -1;
            seat = (row * 8) + column;
            if (seat > highestSeatID) {
                highestSeatID = seat;
            }
        }


        return highestSeatID;
    }
}

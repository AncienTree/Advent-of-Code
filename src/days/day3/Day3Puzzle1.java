package days.day3;

import days.utils.PuzzleInputReader;

import java.util.List;

/**
 * @author Mateusz D�bek
 * @created 11 gru 2020
 */
public class Day3Puzzle1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countTreeForSlope(3, 1));
	}

	static int countTreeForSlope(int right, int down) {
		List<String> input = PuzzleInputReader.getInputString("inputday3.txt");
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

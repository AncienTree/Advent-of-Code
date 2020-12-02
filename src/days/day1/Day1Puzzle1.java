/**
 * 
 */
package days.day1;

import java.util.List;

import days.utils.PuzzleInputReader;

/**
 * @author Mateusz D¹bek
 * @created 2 gru 2020
 */
public class Day1Puzzle1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> input = PuzzleInputReader.getInputInt("inputday1.txt");
		
		for (int i = 0; i < input.size(); i++) {
			for (int j = i + 1; j < input.size(); j++) {
				if(input.get(i) + input.get(j) == 2020) {
					System.out.println(input.get(i) * input.get(j));
					break;
				}
			}
			
		}

	}

}

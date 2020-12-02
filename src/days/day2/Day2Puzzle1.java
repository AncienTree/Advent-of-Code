/**
 * 
 */
package days.day2;

import java.util.List;

import days.utils.PuzzleInputReader;

/**
 * @author Mateusz D¹bek
 * @created 2 gru 2020
 */
public class Day2Puzzle1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> input = PuzzleInputReader.getInputString("inputday2.txt");
		int count = 0;
		
		for (String string : input) {
			if(isValid(string)) {
				count++;
			}
		}		
		System.out.print(count);
	}
	
	private static boolean isValid(String passowrd) {
		int indexOfChar = passowrd.indexOf('-');
		int indexOfSpace = passowrd.indexOf(' ');
		int indexOfColon = passowrd.indexOf(':');

		boolean check = false;
		int min = Integer.parseInt(passowrd.substring(0, indexOfChar));
		int max = Integer.parseInt(passowrd.substring(indexOfChar + 1, indexOfSpace));
		char charCheck = passowrd.charAt(indexOfSpace + 1);
		String pass = passowrd.substring(indexOfColon + 2);
			
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

}

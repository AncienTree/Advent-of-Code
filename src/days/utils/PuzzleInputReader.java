/**
 * 
 */
package days.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz D�bek
 * @created 2 gru 2020
 */
public class PuzzleInputReader {
	
	public static List<Integer> getInputInt(String fileName) {
		List<Integer> inputList = new ArrayList<>();		
		File file = new File(fileName);
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {			
			String str = null;
			while((str = bufferedReader.readLine()) != null) {
				inputList.add(Integer.parseInt(str));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return inputList;		
	}
	
	public static List<String> getInputString(String fileName) {
		List<String> inputList = new ArrayList<>();		
		File file = new File(fileName);
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {			
			String str = null;
			while((str = bufferedReader.readLine()) != null) {
				inputList.add(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return inputList;		
	}
}

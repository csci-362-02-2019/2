package org.openmrs;

import org.openmrs.patient.impl.LuhnIdentifierValidator;
import org.openmrs.patient.UnallowedIdentifierException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//these are what return true for isValid() method
//a-3
//b-1
//c-9
//d-6
//e-4
//f-2
//g-0
//h-8
//i-5
//j-3

public class TestDriver extends LuhnIdentifierValidator {
	
	public static void main(String[] args) {
		
		try {
			//Test 1
			LuhnIdentifierValidator LIV0 = new LuhnIdentifierValidator();
			boolean result1;
			String line1 = Files.readAllLines(Paths.get("/Users/samle/OneDrive/Documents/CSCI 362/testcase1.txt")).get(4);
			result1 = LIV0.isValid(line1);
			System.out.println(result1);
			
			//Test 2
			boolean result2;
			String line2 = Files.readAllLines(Paths.get("/Users/samle/OneDrive/Documents/CSCI 362/testcase2.txt")).get(4);
			result2 = LIV0.isValid(line2);
			System.out.println(result2);

		
			//Test 3
			try {
				LuhnIdentifierValidator LIV1 = new LuhnIdentifierValidator();
				boolean result3;
				String line3 = Files.readAllLines(Paths.get("/Users/samle/OneDrive/Documents/CSCI 362/testcase3.txt")).get(4);
				result3 = LIV1.isValid(line3);
				System.out.println(result3);
			}
			catch (UnallowedIdentifierException | IOException e) {
				System.out.println("UnallowedIdentifierException thrown.");
			}
		
			//Test 4
			LuhnIdentifierValidator LIV2 = new LuhnIdentifierValidator();
			int result4;
			String line4 = Files.readAllLines(Paths.get("/Users/samle/OneDrive/Documents/CSCI 362/testcase4.txt")).get(4);
			result4 = LIV2.getCheckDigit(line4);
			System.out.println(result4);

			//Test 5
			LuhnIdentifierValidator LIV3 = new LuhnIdentifierValidator();
			int result5;
			String line5 = Files.readAllLines(Paths.get("/Users/samle/OneDrive/Documents/CSCI 362/testcase5.txt")).get(4);
			result5 = LIV3.getCheckDigit(line5);
			System.out.println(result5);
		}
		catch (IOException e) {
			System.out.println("error :(");
		}
	}
}

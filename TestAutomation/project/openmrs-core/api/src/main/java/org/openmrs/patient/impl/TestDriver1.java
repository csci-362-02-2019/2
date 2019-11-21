package org.openmrs.patient.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestDriver1 extends LuhnIdentifierValidator {
	public static void main(String[] args) {
		try{//Test 1
			LuhnIdentifierValidator LIV0 = new LuhnIdentifierValidator();
			boolean result1;
			String line1 = Files.readAllLines(Paths.get("/home/wright/testCases/testcase1.txt")).get(4);
			result1 = LIV0.isValid(line1);
			System.out.println(result1);
			}
		catch (IOException e) {
			System.out.println("error :(");
		}
	
	}
}
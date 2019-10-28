package org.openmrs;

import org.openmrs.patient.impl.LuhnIdentifierValidator;
import org.openmrs.patient.UnallowedIdentifierException;

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
		
		//Test 1
		LuhnIdentifierValidator LIV = new LuhnIdentifierValidator();
		boolean result1;
		result1 = LIV.isValid("a-3");
		System.out.println(result1);
		
		//Test 2
		boolean result2;
		result2 = LIV.isValid("a-4");
		System.out.println(result2);
		
		//Test 3
		try {
			boolean result3;
			result3 = LIV.isValid("Sam");
			System.out.println(result3);
		}
		catch (UnallowedIdentifierException e) {
			System.out.println("UnallowedIdentifierException thrown.");
		}
		//Test 4
		LuhnIdentifierValidator LIV2 = new LuhnIdentifierValidator();
		int result4;
		result4 = LIV2.getCheckDigit("a");
		System.out.println(result4);
		
		//Test 5
		int result5;
		result5 = LIV2.getCheckDigit("b");
		System.out.println(result5);

		
	}
}

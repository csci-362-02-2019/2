import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class testdriver2 {
	
	public static boolean isStringInArray(String str, String[] arr) {
		boolean retVal = false;
		
		if (str != null && arr != null) {
			for (String anArr : arr) {
				if (str.equals(anArr)) {
					retVal = true;
				}
			}
		}
		return retVal;
	}

	public static boolean containsDigit(String test) {
		if (test != null) {
			for (char c : test.toCharArray()) {
				if (Character.isDigit(c)) {
					return true;
				}
			}
		}
		return false;
	}

	public static Integer convertToInteger(Long longValue) {
		if (longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(longValue + " cannot be cast to Integer without changing its value.");
		}
		return longValue.intValue();
	}
	
	public static boolean containsUpperAndLowerCase(String test) {
		if (test != null) {
			Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])[\\w|\\W]*$");
			Matcher matcher = pattern.matcher(test);
			return matcher.matches();
		}
		return false;
	}

	public static void main(String[] args) {
		try {
			//testcase 1
			testdriver2 test1 = new testdriver2();
			String line1 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase001")).get(4);
			String[] array1 = line1.split("&",2);
			String[] Xarray1 = array1[1].split(",");

			//testcase 2
			String line2 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase002")).get(4);
			String[] array2 = line2.split("&",2);
			String[] Xarray2 = array2[1].split(",");

			//testcase 3
			String line3 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase003")).get(4);
			String[] array3 = line3.split("&",2);
			String[] Xarray3 = array3[1].split(",");

			//testcase 4
			String line4 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase004")).get(4);
			
			//testcase 5
			String line5 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase005")).get(4);

			//testcase 6
			String line6 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase006")).get(4);

			//testcase 7
			String temp7 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase007")).get(4);
			long line7 = Long.parseLong(temp7, 10);
			
			//testcase 8
			String temp8 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase008")).get(4);
			long line8 = Long.parseLong(temp8, 10);

			//testcase 9
			String line9 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase009")).get(4);

			//testcase 10
			String line10 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase010")).get(4);

			//testcase 11
			String line11 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase011")).get(4);
			
			//testcase 12
			String line12 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase012")).get(4);

			//saving results of testcases
			String result1 = Boolean.toString(test1.isStringInArray(array1[0], Xarray1));
			String result2 = Boolean.toString(test1.isStringInArray(array2[0], Xarray2));
			String result3 = Boolean.toString(test1.isStringInArray(array3[0], Xarray3));
			String result4 = Boolean.toString(test1.containsDigit(line4));
			String result5 = Boolean.toString(test1.containsDigit(line5));
			String result6 = Boolean.toString(test1.containsDigit(line6));
			String result7 = Integer.toString(test1.convertToInteger(line7));
			String result8;
			try {
				result8 = Integer.toString(test1.convertToInteger(line8));
			} catch (Exception e) {
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				result8 = exceptionAsString.substring(0, Math.min(exceptionAsString.length(), 100));
			}
			String result9 = Boolean.toString(test1.containsUpperAndLowerCase(line9));
			String result10 = Boolean.toString(test1.containsUpperAndLowerCase(line10));
			String result11 = Boolean.toString(test1.containsUpperAndLowerCase(line11));
			String result12 = Boolean.toString(test1.containsUpperAndLowerCase(line12));



			//System.out.println("TC1: array1[0] = " + array1[0] + " results1 = " + result1);
			//System.out.println("TC2: array2[0] = " + array2[0] + " results1 = " + result2);
			//System.out.println("TC3: array3[0] = " + array3[0] + " results1 = " + result3);

			//System.out.println("TC4: (" + line4 + ") output: " + result4);
			//System.out.println("TC5: (" + line5 + ") output: " + result5);
			//System.out.println("TC6: (" + line6 + ") output: " + result6);

			//writes results to output file
			BufferedWriter writer = new BufferedWriter(new FileWriter("../2/testcase1Report.txt"));
    			writer.write(result1);
			writer.newLine();
    			writer.write(result2);
			writer.newLine();
    			writer.write(result3);
			writer.newLine();
    			writer.write(result4);
			writer.newLine();
    			writer.write(result5);
     			writer.newLine();
    			writer.write(result6);
     			writer.newLine();
    			writer.write(result7);
			writer.newLine();
    			writer.write(result8);
			writer.newLine();
    			writer.write(result9);
			writer.newLine();
    			writer.write(result10);
			writer.newLine();
    			writer.write(result11);
			writer.newLine();
    			writer.write(result12);


    			writer.close();


		} catch (IOException e) {
			System.out.println(e);
		}
	}
}


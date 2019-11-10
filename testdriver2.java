import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

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
	

	public static void main(String[] args) {
		try {
			//testcase 1
			testdriver2 test1 = new testdriver2();
			String line1 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase1")).get(4);
			String[] array1 = line1.split("&",2);
			String[] Xarray1 = array1[1].split(",");

			//testcase 2
			String line2 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase2")).get(4);
			String[] array2 = line2.split("&",2);
			String[] Xarray2 = array2[1].split(",");

			//testcase 3
			String line3 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase3")).get(4);
			String[] array3 = line3.split("&",2);
			String[] Xarray3 = array3[1].split(",");

			//testcase 4
			String line4 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase4")).get(4);
			
			//testcase 5
			String line5 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase5")).get(4);

			//testcase 6
			String line6 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase6")).get(4);

			//saving results of testcases
			String result1 = Boolean.toString(test1.isStringInArray(array1[0], Xarray1));
			String result2 = Boolean.toString(test1.isStringInArray(array2[0], Xarray2));
			String result3 = Boolean.toString(test1.isStringInArray(array3[0], Xarray3));
			String result4 = Boolean.toString(test1.containsDigit(line4));
			String result5 = Boolean.toString(test1.containsDigit(line5));
			String result6 = Boolean.toString(test1.containsDigit(line6));

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

    			writer.close();


		} catch (IOException e) {
			System.out.println(e);
		}
	}
}


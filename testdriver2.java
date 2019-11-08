import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

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
			//System.out.println("HelloWorld! this is new");
			testdriver2 test1 = new testdriver2();
			String[] array = {"Sam","Wright"};
			String sam = "Sam";
			String line1 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase1")).get(4);
			String[] array1 = line1.split("|");
			System.out.println(test1.isStringInArray(array1[0], array1));
			System.out.println(test1.containsDigit(sam));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}


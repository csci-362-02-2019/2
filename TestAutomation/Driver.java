import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;

@SuppressWarnings("deprecation")
public class Driver {
	
	public static void main(String[] args) {
		try {
			//gets user directory and sets up path to testcases
			String home = System.getProperty("user.home");
			File f = new File(home + "/2/TestAutomation/testCases/testcase00");
			String fname = f.toString();
			
			//change this depending on the number of test cases in the testCases folder
			int numOfTestCases = 25;
			
			//starting up the writer
			BufferedWriter writer = new BufferedWriter(new FileWriter(home + "/2/TestAutomation/driverReport.txt"));

			String result;

			for (int i = 1; i <= numOfTestCases; i++) {
				
				//removes second zero from fname for double digits
				if (i >= 10) {
					fname = home + "/2/TestAutomation/testCases/testcase0";	
				}
				
				//converts i to a string for the next line
				String j = Integer.toString(i);
				
				//get method name from test case
				String methodCalled = Files.readAllLines(Paths.get(fname + j)).get(3);

				methods tester = new methods();

				String line = Files.readAllLines(Paths.get(fname + j)).get(4);

				//isStringArray method		
				if (methodCalled.equals("isStringinArray(String str, String[] arr)")) {	
					String[] array = line.split("&",2);
					String[] Xarray = array[1].split(",");
					result = Boolean.toString(tester.isStringInArray(array[0], Xarray));
		    			writer.write(result);

				//containsDigit method
				} else if (methodCalled.equals("containsDigit(String test)")) {
					result = Boolean.toString(tester.containsDigit(line));
		    			writer.write(result);

				//convertToInteger method
				} else if (methodCalled.equals("convertToInteger(Long longvalue)")) {
					long long1 = Long.parseLong(line, 10);
					try {
						result = Integer.toString(tester.convertToInteger(long1));
					} catch (Exception e) {
						StringWriter sw = new StringWriter();
						e.printStackTrace(new PrintWriter(sw));
						String exceptionAsString = sw.toString();
						result = exceptionAsString.substring(0, Math.min(exceptionAsString.length(), 100));
					}
					writer.write(result);

				//containsUpperAndLowerCase method
				} else if (methodCalled.equals("containsUpperAndLowerCase(String test)")) {
					result = Boolean.toString(tester.containsUpperAndLowerCase(line));
					writer.write(result);

				//Format method	
				} else if (methodCalled.equals("format(Date date, Locale locale, FORMAT_TYPE type)")) {
					String[] arr = line.split(",");
					if (arr[0].equals("") || arr[1].equals("") || arr[2].equals("")) {
						writer.write("null");
					} else {
						String[] dateArr = arr[0].split("/");
						Locale myLocale = new Locale.Builder().setLanguage("en").build();
						Date myDate = new Date();
						myDate.setMonth((Integer.parseInt(dateArr[0]))-1);
						myDate.setDate(Integer.parseInt(dateArr[1]));
						myDate.setSeconds(00);
						methods.FORMAT_TYPE myFT = methods.FORMAT_TYPE.DATE;
						if (arr[1].equals("US")) {
							myLocale = Locale.US;
						} else if (arr[1].equals("JAPAN")) {
							myLocale = Locale.JAPAN;
						}		
						if (arr[2].equals("DATE")) {
							myDate.setYear(Integer.parseInt(dateArr[2]));
							myFT = methods.FORMAT_TYPE.DATE;
						} else if (arr[2].equals("TIME")) {
							String[] timeArr = dateArr[3].split(":");
							myDate.setYear(Integer.parseInt(dateArr[2]));
							myDate.setHours(Integer.parseInt(timeArr[0]));
							myDate.setMinutes(Integer.parseInt(timeArr[1]));
							myFT = methods.FORMAT_TYPE.TIME;
						} else if (arr[2].equals("TIMESTAMP")) {
							String[] timeArr = dateArr[3].split(":");
							myDate.setYear(Integer.parseInt(dateArr[2])-1900);
							myDate.setHours(Integer.parseInt(timeArr[0]));
							myDate.setMinutes(Integer.parseInt(timeArr[1]));
							myFT = methods.FORMAT_TYPE.TIMESTAMP;
						}
						result = tester.format(myDate,myLocale,myFT);
						writer.write(result);
					}

				//nullSafeEqualsIgnoreCase method	
				} else if (methodCalled.equals("nullSafeEqualsIgnoreCase(String s1, String s2)")) {
					String[] arr = line.split(",",2);
					result = Boolean.toString(tester.nullSafeEqualsIgnoreCase(arr[0],arr[1]));
					writer.write(result);				
				}
				writer.newLine();
			}
    			writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

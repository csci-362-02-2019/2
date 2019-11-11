import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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

	public enum FORMAT_TYPE {
		DATE,
		TIME,
		TIMESTAMP
	}
	
	public static String format(Date date, Locale locale, FORMAT_TYPE type) {
		if (date == null || locale == null || type == null) {
			return "";
		}
		//log.debug("Formatting date: " + date + " with locale " + locale);
		
		DateFormat dateFormat;
		
		if (type == FORMAT_TYPE.TIMESTAMP) {
			dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		} else if (type == FORMAT_TYPE.TIME) {
			dateFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM, locale);
		} else {
			dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		}
		return dateFormat.format(date);
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

			//testcase 13
			String line13 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase013")).get(4);
			String[] arr13 = line13.split(",");
			String[] dateArr = arr13[0].split("/");
			Date myDate = new Date();
			myDate.setYear(Integer.parseInt(dateArr[2]));
			myDate.setMonth((Integer.parseInt(dateArr[0]))-1);
			myDate.setDate(Integer.parseInt(dateArr[1]));
			Locale myLocale = new Locale.Builder().setLanguage("en").build();		
			if (arr13[1].equals("US")) {
				myLocale = Locale.US;
			} 
			FORMAT_TYPE myFT = FORMAT_TYPE.DATE;
			
			//testcase 14
			String line14 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase014")).get(4);
			String[] arr14 = line14.split(",");
			String[] dateArr14 = arr14[0].split("/");
			Date myDate14 = new Date();
			myDate14.setYear(Integer.parseInt(dateArr14[2]));
			myDate14.setMonth((Integer.parseInt(dateArr14[0]))-1);
			myDate14.setDate(Integer.parseInt(dateArr14[1]));
			Locale myLocale14 = new Locale.Builder().setLanguage("en").build();		
			if (arr14[1].equals("JAPAN")) {
				myLocale14 = Locale.JAPAN;
			} 
			FORMAT_TYPE myFT14 = FORMAT_TYPE.DATE;

			//testcase 15
			String line15 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase015")).get(4);
			String[] arr15 = line15.split(",");
			String[] dateArr15 = arr15[0].split("/");
			String[] timeArr15 = dateArr15[3].split(":");
			int year15 = Integer.parseInt(dateArr15[2]);
			int month15 = Integer.parseInt(dateArr15[0])-1;
			int day15 = (Integer.parseInt(dateArr15[1]));
			int hour15 = Integer.parseInt(timeArr15[0]);
			int min15 = Integer.parseInt(timeArr15[1]);
			Date myDate15 = new Date(year15,month15,day15,hour15,min15);	
			Locale myLocale15 = new Locale.Builder().setLanguage("en").build();		
			if (arr15[1].equals("US")) {
				myLocale15 = Locale.US;
			} 
			//will need to add an if statement here eventually
			FORMAT_TYPE myFT15 = FORMAT_TYPE.TIME;

			//testcase 16
			String line16 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase016")).get(4);
			String[] arr16 = line16.split(",");
			String[] dateArr16 = arr16[0].split("/");
			String[] timeArr16 = dateArr16[3].split(":");
			int year16 = Integer.parseInt(dateArr16[2]);
			int month16 = Integer.parseInt(dateArr16[0])-1;
			int day16 = (Integer.parseInt(dateArr16[1]));
			int hour16 = Integer.parseInt(timeArr16[0]);
			int min16 = Integer.parseInt(timeArr16[1]);
			Date myDate16 = new Date(year16,month16,day16,hour16,min16);	
			Locale myLocale16 = new Locale.Builder().setLanguage("en").build();		
			if (arr16[1].equals("JAPAN")) {
				myLocale16 = Locale.JAPAN;
			} 
			//will need to add an if statement here eventually
			FORMAT_TYPE myFT16 = FORMAT_TYPE.TIME;

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
			String result13 = test1.format(myDate,myLocale,myFT);
			String result14 = test1.format(myDate14,myLocale14,myFT14);
			String result15 = test1.format(myDate15,myLocale15,myFT15);
			String result16 = test1.format(myDate16,myLocale16,myFT16);


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
			writer.newLine();
    			writer.write(result13);
			writer.newLine();
    			writer.write(result14);
			writer.newLine();
    			writer.write(result15);
			writer.newLine();
    			writer.write(result16);


    			writer.close();


		} catch (IOException e) {
			System.out.println(e);
		}
	}
}


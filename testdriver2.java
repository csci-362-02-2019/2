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

			//testcase 17
			String line17 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase017")).get(4);
			String[] arr17 = line17.split(",");
			String[] dateArr17 = arr17[0].split("/");
			String[] timeArr17 = dateArr17[3].split(":");
			int year17 = Integer.parseInt(dateArr17[2])-1900;
			int month17 = Integer.parseInt(dateArr17[0])-1;
			int day17 = (Integer.parseInt(dateArr17[1]));
			int hour17 = Integer.parseInt(timeArr17[0]);
			int min17 = Integer.parseInt(timeArr17[1]);
			Date myDate17 = new Date(year17,month17,day17,hour17,min17);	
			Locale myLocale17 = new Locale.Builder().setLanguage("en").build();		
			if (arr17[1].equals("US")) {
				myLocale17 = Locale.US;
			} 
			//will need to add an if statement here eventually
			FORMAT_TYPE myFT17 = FORMAT_TYPE.TIMESTAMP;

			//testcase 18
			String line18 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase018")).get(4);
			String[] arr18 = line18.split(",");
			String[] dateArr18 = arr18[0].split("/");
			String[] timeArr18 = dateArr18[3].split(":");
			int year18 = Integer.parseInt(dateArr18[2])-1900;
			int month18 = Integer.parseInt(dateArr18[0])-1;
			int day18 = (Integer.parseInt(dateArr18[1]));
			int hour18 = Integer.parseInt(timeArr18[0]);
			int min18 = Integer.parseInt(timeArr18[1]);
			Date myDate18 = new Date(year18,month18,day18,hour18,min18);	
			Locale myLocale18 = new Locale.Builder().setLanguage("en").build();		
			if (arr18[1].equals("JAPAN")) {
				myLocale18 = Locale.JAPAN;
			} 
			//will need to add an if statement here eventually
			FORMAT_TYPE myFT18 = FORMAT_TYPE.TIMESTAMP;

			//test case 19
			String line19 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase019")).get(4);
			String[] arr19 = line19.split(",");
			String[] dateArr19 = arr19[0].split("/");
			String[] timeArr19 = dateArr19[3].split(":");
			int year19 = Integer.parseInt(dateArr19[2])-1900;
			int month19 = Integer.parseInt(dateArr19[0])-1;
			int day19 = (Integer.parseInt(dateArr19[1]));
			int hour19 = Integer.parseInt(timeArr19[0]);
			int min19 = Integer.parseInt(timeArr19[1]);
			Date myDate19 = new Date(year19,month19,day19,hour19,min19);	
			Locale myLocale19 = new Locale.Builder().setLanguage("en").build();		
			if (arr19[1].equals("")) {
				myLocale19 = null;
			} 
			//will need to add an if statement here eventually
			FORMAT_TYPE myFT19 = FORMAT_TYPE.TIME;

			//test case 20
			FORMAT_TYPE myFT20 = null;
			Locale myLocale20 = null;
			Date myDate20 = null;
			String[] arr20 = null;
			try {
				String line20 = Files.readAllLines(Paths.get("../2/TestAutomation/testCases/testcase020")).get(4);
				arr20 = line20.split(",");
				String[] dateArr20 = arr20[0].split("/");
				int year20 = Integer.parseInt(dateArr20[2]);
				int month20 = Integer.parseInt(dateArr20[0])-1;
				int day20 = (Integer.parseInt(dateArr20[1]));
				myDate20 = new Date(year20,month20,day20);	
				myLocale20 = new Locale.Builder().setLanguage("en").build();		
				if (arr20[1].equals("")) {
					myLocale20 = null;
				} 
				//will need to add an if statement here eventually
				myFT20 = FORMAT_TYPE.TIME;
			} catch (Exception e) {
				if (arr20 == null) {
					myDate20 = null;
				}	
			}	

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
			String result17 = test1.format(myDate17,myLocale17,myFT17);
			String result18 = test1.format(myDate18,myLocale18,myFT18);
			String result19 = test1.format(myDate19,myLocale19,myFT19);
			String result20 = test1.format(myDate20,myLocale20,myFT20);


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
			writer.newLine();
    			writer.write(result17);
			writer.newLine();
    			writer.write(result18);
			writer.newLine();
    			writer.write(result19);
			writer.newLine();
    			writer.write(result20);
    			writer.close();


		} catch (IOException e) {
			System.out.println(e);
		}
	}
}


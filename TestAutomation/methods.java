
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
import java.util.Calendar;

public class methods {
	
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
			Pattern pattern = Pattern.compile("^(?=.?[A-Z])(?=.*?[a-z])[\\w|\\W]*$");
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
	
	public static boolean nullSafeEqualsIgnoreCase(String s1, String s2) {
		if (s1 == null) {
			return s2 == null;
		} else if (s2 == null) {
			return false;
		}
		
		return s1.equalsIgnoreCase(s2);
	}
}

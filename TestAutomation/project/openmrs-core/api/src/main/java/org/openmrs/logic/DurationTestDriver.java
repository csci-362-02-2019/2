package org.openmrs.logic;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.openmrs.logic.Duration.Units;

public class DurationTest {
	
	public static enum Units {
		SECONDS,
		MINUTES,
		HOURS,
		DAYS,
		WEEKS,
		MONTHS,
		YEARS
	}
	
	private double duration;
	private Units units;
	
	private void Duration(Double duration, Units units) {
		this.duration = duration;
		this.units = units;
	}
	
	public Double getDurationInDays() {
		switch (units) {
			case SECONDS:
				return duration / 86400;
			case MINUTES:
				return duration / 1440;
			case HOURS:
				return duration / 24;
			case DAYS:
				return duration;
			case WEEKS:
				return duration * 7;
			case MONTHS:
				return duration * 30;
			case YEARS:
				return duration * 365;
			default:
				return 0d;
	
		}
	}
	public static void main(String[] args) {
		String line4 = Files.readAllLines(Paths.get(/home/wright/2/TestAutomation/TestCase1.txt));

	}
}

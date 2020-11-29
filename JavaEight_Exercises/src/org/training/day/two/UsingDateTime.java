package org.training.day.two;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UsingDateTime {

	public static void main(String[] args) {
		
		// Getting Current Date
		LocalDate today = LocalDate.now();
		
		  System.out.println("Formatted Date:=" +
		      today.format(DateTimeFormatter.ofPattern("dd-MMM-YYYY")));
		
		System.out.println("Today Date: "+today.getDayOfMonth());
		// Getting Curent Time
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		
		System.out.println("Today :="+ today);
		
		System.out.println("Current Time & Date:="+ currentTime);
		
	// Converting java.util.Date to LocalDate
		Date legacy = new Date();
		
		LocalDate fromLegacy =legacy.toInstant().atZone(ZoneId.of("Asia/Karachi")).toLocalDate();

		System.out.println("From Legacy"+ fromLegacy);
	}

}

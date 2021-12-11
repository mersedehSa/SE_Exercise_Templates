package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.GregorianCalendar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Calendar;

class TestCalendar {

	@ParameterizedTest
	@ValueSource(ints= {1804,1904,2000,2012,2016,2020,2140,2400})
	public void Should_return_true(int year) {
		Calendar calendar = new Calendar(year);
		assertTrue(calendar.isLeapYear());
	}

	@ParameterizedTest
	@ValueSource(ints= {2013,1800,2021,2401,2014})
	public void Should_return_false(int year) {
		Calendar calendar = new Calendar(year);
		assertFalse(calendar.isLeapYear());
	}

	@ParameterizedTest
	@ValueSource(ints= {1800,1900,2000,2009,2016,2020,2140,2400})
	public void Should_return_if_year_is_leap(int year) {
		Calendar calendar = new Calendar(year);
		GregorianCalendar gc= new GregorianCalendar();
		
		if(gc.isLeapYear(year)) {
			assertTrue(calendar.isLeapYear());
		}
		else {
			assertFalse(calendar.isLeapYear());
		}
	}
	
	@ParameterizedTest
	@ValueSource(ints= {1,Integer.MAX_VALUE})	//UntereGrenze 1, weil Jahr 0 nach gregorianischem Kalender nicht existiert
	public void Should_test_boundaries(int year){
		Calendar calendar = new Calendar(year);
		GregorianCalendar gc= new GregorianCalendar();
		
		if(gc.isLeapYear(year)) {
			assertTrue(calendar.isLeapYear());
		}
		else {
			assertFalse(calendar.isLeapYear());
		}
	}
	// Create a new method for boundary testing
}

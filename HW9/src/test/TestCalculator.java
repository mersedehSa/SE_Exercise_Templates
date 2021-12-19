package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.Calculator;


class TestCalculator {

	Calculator calculator = new Calculator();

	@Test
	public void Should_add_two_numbers_and_return_result() {
		assertEquals(0, calculator.add(3, -3));
	}

	@ParameterizedTest
	@CsvSource({
	    "1,	8",
	    "2,	7",
	    "3, 6",
	    "4,	5",
	    "5, 4",
	    "6, 3"
	})
	public void Should_add_two_numbers_and_return_result_parameterized(int valueOne, int valueTwo) {
		int expected=valueOne+valueTwo;
		assertEquals(expected, calculator.add(valueOne, valueTwo));
	}
	
	@Test
	public void Should_substract_two_numbers_and_return_result() {
		assertEquals(55, calculator.sub(65, 10));
	}
	
	@Test
	public void Should_multiply_two_numbers_and_return_result() {
		 assertEquals(64, calculator.multiply(8, 8));
	}
	
	
	@Test
	public void Should_divide_two_numbers_and_return_result() {
		assertEquals(2.5, calculator.divide(5, 2),0.0);
	}
	
	@Test
	public void Should_throw_an_arithmetic_exception_if_denominator_is_zero() {
		Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () ->
        calculator.divide(10, 0));
    assertEquals("ZeroDivisionError", exception.getMessage());
	}
}

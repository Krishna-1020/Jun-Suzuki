package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class CarTest {

	private String[] carToStringArray(Car car) {
		String[] carString = { car.getMake(), car.getModel(), String.valueOf(car.getYear()) };
		return carString;
	}

	@Test
	public void compareCarWithMakeModelYear() {
		Car actual = new Car("Honda", "Jazz",200000, 30, 2015);
		String[] expected = { "Honda", "Jazz", "2015" };
		assertArrayEquals(expected, carToStringArray(actual));
	}

}
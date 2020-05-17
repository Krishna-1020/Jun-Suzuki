package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest{
	@Test
	public void multiply3By4(){
		Calculator cut = new Calculator();
		float actual = cut.multiply(3,4);
		float expected = 12;
		assertEquals(expected, actual); 
	}
	
	@Test
	public void multiply2By0(){
		Calculator cut = new Calculator();
		float actual = cut.multiply(2,0);
		float expected = 0;
		assertEquals(expected, actual); 
	}
	
	@Test
	public void divide3By2(){
		Calculator cut = new Calculator();
		float actual = cut.divide(3,2);
		float expected = 1.5f;
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideminus3By2(){
		Calculator cut = new Calculator();
		float actual = cut.divide(-3,2);
		float expected = -1.5f;
		assertEquals(expected, actual);
	}
}
package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {
	
	@Test
	public void primeGenerator1to15() {
		PrimeGenerator gen = new PrimeGenerator(1, 15);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L};
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
		}



		@Test
		public void primeGeneratorminus10to10() {
		long from = -10;
		long to = 10;
		try{

		PrimeGenerator gen = new PrimeGenerator(from, to);
		gen.generatePrimes();
		Long[] expectedPrimes = {};
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
		//throw new IllegalArgumentException("Only Positive NumbersAccepted as Input R//ange");
		}
		catch(RuntimeException ex){
		assertEquals("Wrong input values: from=" + from + " to=" + to,ex.getMessage());
		System.out.println("Invalid");
		}

		}


		@Test
		public void primeGenerator321to330() {
		long from = 321;
		long to = 330;
		try{

		PrimeGenerator gen = new PrimeGenerator(from, to);
		gen.generatePrimes();
		Long[] expectedPrimes = {};
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
		}
		catch(RuntimeException ex){
		assertEquals("Wrong input values: from=" + from + " to=" + to,ex.getMessage());
		//System.out.println(ex.getMessage());
		}

		}

		
		@Test
		public void primeGenerator100to1() {
		long from = 100; // implicit type casting int to long
		long to = 1;
		try{

		PrimeGenerator gen = new PrimeGenerator(from, to);
		gen.generatePrimes();
		Long[] expectedPrimes = {};
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
		}
		catch(RuntimeException ex){
		assertEquals("Wrong input values: from=" + from + " to=" + to,ex.getMessage());
		//System.out.println(ex.getMessage());
		}

		}

}

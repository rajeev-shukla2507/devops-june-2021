package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class HelloTest {

	@Test
	public void testSayHello() {

		Hello hello = new Hello();

		String expectedResponse = "Hello DevOps!";
		String actualResponse   = hello.sayHello();

		assertEquals ( expectedResponse, actualResponse );

	}

	@Test
	public void testAddition() {
		double firstNumber = 43.0;
		double secondNumber = 57.0;

		double actualResult = firstNumber + secondNumber;

		assertEquals( 100.00, actualResult, 0.0001 );

	}

}
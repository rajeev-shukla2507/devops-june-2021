package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class BackEndTest {

	@Test
	public void testBackEnd() {

		BackEnd be = new BackEnd();

		String actualResponse   = be.getModuleName();
		String expectedResponse = "BackEnd Module";

		assertEquals ( expectedResponse, actualResponse );

	}

}
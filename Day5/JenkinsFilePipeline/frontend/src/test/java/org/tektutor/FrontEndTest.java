package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class FrontEndTest {

	@Test
	public void testFrontEnd() {

		FrontEnd fe = new FrontEnd();

		String actualResponse   = fe.getModuleName();
		String expectedResponse = "FrontEnd Module";

		assertEquals ( expectedResponse, actualResponse );

	}

}
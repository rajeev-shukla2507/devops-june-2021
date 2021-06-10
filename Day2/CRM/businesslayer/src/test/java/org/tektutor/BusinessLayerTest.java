package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class BusinessLayerTest {

	@Test
	public void testBusinessLayer() {

		BusinessLayer bl = new BusinessLayer();

		String actualResponse   = bl.getModuleName();
		String expectedResponse = "BusinessLayer Module";

		assertEquals ( expectedResponse, actualResponse );

	}

}

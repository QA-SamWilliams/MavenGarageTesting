package com.qa.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class Test_Garage {
	@Before
	public void setup() {
		
	}
	@Test
	public void getInstanceTest() {
		assertEquals(true, Garage.getInstance());
	}
}

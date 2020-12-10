package com.qa.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import com.qa.utils.Garage;
import com.qa.vehicles.Car;
import java.util.ArrayList;

public class Test_CarDAO {
	
	CarDAO carDAO = new CarDAO();
	Car testCar = new Car(4, "Black", "BMW", 250);
	Car testCar2 = new Car(4, "Red", "AMG", 300);
	ArrayList<Car> testList = new ArrayList<Car>();
	
	@Before
	public void setup() {
		testCar.setId(1);
		testCar2.setId(2);
		carDAO.create(testCar);
		carDAO.create(testCar2);
		testList.add(testCar);
		testList.add(testCar2);
	}
	
	@After
	public void cleanup() {
		Garage garage = Garage.getInstance();
		garage.clearGarage();
	}
	
	@Test
	public void carCreateTest() {
		assertEquals(testCar, carDAO.create(testCar));
	}
	
	@Test
	public void carReadTest() {
		assertEquals(testCar, carDAO.read(1));
	}
	
	@Test
	public void carReadAllTest() {
		assertEquals(testList, carDAO.readAll());
	}
	
	@Test
	public void carDeleteTest() {
		testList.remove(testCar);
		assertTrue(carDAO.delete(1));
	}
}


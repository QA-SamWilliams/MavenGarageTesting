package com.qa.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.*;

import com.qa.utils.Garage;
import com.qa.vehicles.Car;

public class Test_CarDAO {
	CarDAO carDAO = new CarDAO();
	Car testCar = new Car(4,"Blue","Mercedes",400);
	Car testCar2 = new Car(3,"Red","Reliant",45);
	ArrayList<Car> cars = new ArrayList<>();
	
	@Before
	public void  setup() {
		testCar.setId(1);
		testCar2.setId(2);
		carDAO.create(testCar);
		carDAO.create(testCar2);
	}
	
	@After
	public void teardown() {
		Garage garage = Garage.getInstance();
		garage.clearGarage();
	}
	
	@Test
	public void testCreate() {
		Car myCar = new Car(4,"Grey","Subaru",250);
		assertEquals(myCar,carDAO.create(myCar));
	}
	
	@Test
	
	public void testRead() {
		carDAO.create(testCar);
		carDAO.create(testCar2);
		assertEquals(testCar, carDAO.read(1)); 
	}
	
	@Test
	
	public void testDelete() {
		assertTrue(carDAO.delete(2));
	}
	
	@Test
	
	public void testDeleteFalse() {
		assertFalse(carDAO.delete(6525895)); 
	}
	
	@Test
	
	public void testReadAll() {
		cars.add(testCar);
		cars.add(testCar2);
		
		assertEquals(cars, carDAO.readAll());
		
	}
	
	
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package AirlineTicketBookingCode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wangx
 */
public class TripTest {
    
    public TripTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of planeFlightTime method, of class Trip.
     */
    @Test
    public void testPlaneFlightTime() {
        System.out.println("planeFlightTime");
        String arrivalCity = "";
        Trip instance = new Trip();
        int expResult = 0;
        int result = instance.planeFlightTime(arrivalCity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createDepartureTime method, of class Trip.
     */
    @Test
    public void testCreateDepartureTime() {
        System.out.println("createDepartureTime");
        Trip instance = new Trip();
        String expResult = "";
        String result = instance.createDepartureTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArrivalTime method, of class Trip.
     */
    @Test
    public void testSetArrivalTime() {
        System.out.println("setArrivalTime");
        Trip instance = new Trip();
        String expResult = "";
        String result = instance.setArrivalTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of timeOfDay method, of class Trip.
     */
    @Test
    public void testTimeOfDay() {
        System.out.println("timeOfDay");
        int time = 0;
        Trip instance = new Trip();
        String expResult = "";
        String result = instance.timeOfDay(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createFlightNumber method, of class Trip.
     */
    @Test
    public void testCreateFlightNumber() {
        System.out.println("createFlightNumber");
        Trip instance = new Trip();
        String expResult = "";
        String result = instance.createFlightNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createGateNumber method, of class Trip.
     */
    @Test
    public void testCreateGateNumber() {
        System.out.println("createGateNumber");
        Trip instance = new Trip();
        String expResult = "";
        String result = instance.createGateNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTrip method, of class Trip.
     */
    @Test
    public void testDisplayTrip() throws Exception {
        System.out.println("displayTrip");
        Trip instance = new Trip();
        instance.displayTrip();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

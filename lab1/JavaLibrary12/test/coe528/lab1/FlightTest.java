/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package coe528.lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class FlightTest {
    
    public FlightTest() {
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
     * Test of setFlightNumber method, of class Flight.
     */
    
    @Test
    public void testFlightConstructor() {
       System.out.println("testConstructor");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        assertEquals(1000, test.getFlightNumber());
        assertEquals("Toronto", test.getOrigin());
        assertEquals("Kolkata", test.getDestination());
        assertEquals("03/02/99 7:50 pm", test.getDepartureTime());
        assertEquals(200, test.getCapacity());
        assertEquals(600, test.getOriginalPrice(), 0.001);
    }
    
    
    @Test
    public void testSetFlightNumber() {
        System.out.println("setFlightNumber");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        test.setFlightNumber(550);
        int expResult = 550;
        assertEquals(expResult, test.getFlightNumber());
    }

    /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        test.setOrigin("Edmonton");
        String expResult = "Edmonton";
        assertEquals(expResult, test.getOrigin());    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        test.setDestination("Paris");
        String expResult = "Paris";
        assertEquals(expResult, test.getDestination());
    }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        System.out.println("setDepartureTime");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        test.setDepartureTime("04/22/00 12:50 pm");
        String expResult = "04/22/00 12:50 pm";
        assertEquals(expResult, test.getDepartureTime());    }

    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        test.setCapacity(550);
        int expResult = 550;
        assertEquals(expResult, test.getCapacity());
    }

    /**
     * Test of setNumberofSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetNumberOfSeatsLeft() {
        System.out.println("setNumberOfSeatsLeft");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        test.setNumberOfSeatsLeft(550);
        int expResult = 550;
        assertEquals(expResult, test.getNumberOfSeatsLeft());
    }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        System.out.println("setOriginalPrice");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        test.setOriginalPrice(700);
        double expResult = 700;
        assertEquals(expResult, test.getOriginalPrice(), 0.001);
    }

    /**
     * Test of getFlightNumber method, of class Flight.
     */
    @Test
    public void testGetFlightNumber() {
        System.out.println("getFlightNumber");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        int expResult = 1000;
        int result = test.getFlightNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        String expResult = "Toronto";
        String result = test.getOrigin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        String expResult = "Kolkata";
        String result = test.getDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        System.out.println("getDepartureTime");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        String expResult = "03/02/99 7:50 pm";
        String result = test.getDepartureTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        int expResult = 200;
        int result = test.getCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumSeatsLeft method, of class Flight.
     */
    @Test
    public void testGetNumberOfSeatsLeft() {
        System.out.println("getNumberOfSeatsLeft");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        int expResult = 200;
        int result = test.getNumberOfSeatsLeft();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        System.out.println("getOriginalPrice");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        double expResult = 600;
        double result = test.getOriginalPrice();
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {
       System.out.println("bookASeat");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        boolean expResult = true;
        boolean result = test.bookASeat();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Flight test = new Flight(1000, "Toronto", "Kolkata", "03/02/99 7:50 pm", 200, 600);
        String expResult = "Flight 1000, Toronto to Kolkata, 03/02/99 7:50 pm, original price: 600.0$";
        String result = test.toString();
        assertEquals(expResult, result);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidConstructor() {
        System.out.println("invalidConstructor");
        Flight test = new Flight(1000, "Toronto", "Toronto", "03/02/99 7:50 pm", 200, 600);
    }
    
}
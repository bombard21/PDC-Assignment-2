/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dataBaseCode;

import java.sql.Connection;
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
public class DBManagerTest {
    
    public DBManagerTest() {
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
     * Test of establishConnection method, of class DBManager.
     */
    @Test
    public void testEstablishConnection() {
        System.out.println("establishConnection");
        DBManager instance = new DBManager();
        instance.establishConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class DBManager.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        DBManager instance = new DBManager();
        instance.closeConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConnection method, of class DBManager.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        DBManager instance = new DBManager();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DBManager.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DBManager.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

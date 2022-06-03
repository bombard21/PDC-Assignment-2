/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dataBaseCode;

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
public class DBWriterTest {
    
    public DBWriterTest() {
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
     * Test of createRegisterDatabase method, of class DBWriter.
     */
    @Test
    public void testCreateRegisterDatabase() {
        System.out.println("createRegisterDatabase");
        DBWriter instance = new DBWriter();
        instance.createRegisterDatabase();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkLoginToRegister method, of class DBWriter.
     */
    @Test
    public void testCheckLoginToRegister() {
        System.out.println("checkLoginToRegister");
        DBWriter instance = new DBWriter();
        instance.checkLoginToRegister();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addRegisterInputToDB method, of class DBWriter.
     */
    @Test
    public void testAddRegisterInputToDB() {
        System.out.println("addRegisterInputToDB");
        DBWriter instance = new DBWriter();
        instance.addRegisterInputToDB();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of createTicketDatabase method, of class DBWriter.
     */
    @Test
    public void testCreateTicketDatabase() {
        System.out.println("createTicketDatabase");
        DBWriter instance = new DBWriter();
        instance.createTicketDatabase();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addTicketData method, of class DBWriter.
     */
    @Test
    public void testAddTicketData() {
        System.out.println("addTicketData");
        DBWriter instance = new DBWriter();
        instance.addTicketData();
        // TODO review the generated test code and remove the default call to fail.
    }



    
}

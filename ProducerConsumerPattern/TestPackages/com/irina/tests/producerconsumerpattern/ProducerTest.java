/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irina.tests.producerconsumerpattern;

import com.irina.producerconsumerpattern.Producer;
import com.irina.producerconsumerpattern.QueueOfItems;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author SERGIU
 */
public class ProducerTest {
        private QueueOfItems qOfItemsDouble = Mockito.mock(QueueOfItems.class);
    
      public ProducerTest() {
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
     * Test of run method, of class Producer.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Producer instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
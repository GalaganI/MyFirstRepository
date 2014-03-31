/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irina.tests.producerconsumerpattern;

import com.irina.producerconsumerpattern.Consumer;
import com.irina.producerconsumerpattern.QueueOfItems;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 *
 * @author SERGIU
 */
public class ConsumerTest {
    
   
    
    
//    @After
//    public void tearDown() {
//        Thread.yield();
//    }

    /**
     * Test of run method, of class Consumer, when retrieved from Queue item==null.
     */
    @Test
    public void testRun() {
        
       QueueOfItems queueOfItemsMock=mock(QueueOfItems.class);
        Consumer consumer = new Consumer("TestConsumer", queueOfItemsMock) ;
        ///
        when(queueOfItemsMock.retrieveItem()).thenReturn(null);
        consumer.run();
        assertEquals(consumer.getTotalConsumedItemsCounter(), 0);
            
          

}
    /**
     * Test of run method, of class Consumer, when retrieved from Queue item!=null.
     */
    @Test
    public void testRun2() {
        
        QueueOfItems queueOfItemsMock=mock(QueueOfItems.class);
        Consumer consumer = new Consumer("TestConsumer", queueOfItemsMock) ;
        ///
        when(queueOfItemsMock.retrieveItem()).thenReturn(35);
        consumer.run();
        assertEquals(consumer.getTotalConsumedItemsCounter(), 1);
        Thread.yield();
          

       }
}

package com.irina;

/**
 *
 * @author Irina
 */
public class ProducerConsumerPattern {
   
    private static final int TOTAL_ITEMS_COUNT = 20;
    private static final int MAX_SIZE = 10;
    public static void main (String args[]){
        
        
    //Create shared object
        Queue sharedQueue = new Queue(MAX_SIZE);
     
        //Creating producer and consumers threads
        Thread producer = new Thread (new Producer("Producer ",sharedQueue,TOTAL_ITEMS_COUNT));
        Thread consumer1= new Thread(new Consumer("Consumer 1",sharedQueue));
        Thread consumer2=new Thread(new Consumer("Consumer 2" ,sharedQueue));
     
        //Starting producer and consumers threads
        producer.start();
        consumer1.start();
        consumer2.start();
    }
}

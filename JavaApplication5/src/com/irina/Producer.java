/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irina;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Irina
 */
public class Producer implements Runnable{
    
    private String name;
    private final Queue sharedQueue;
    private int maxItemsToProduce;
    private static Random r =new Random();
    private static int numberOfActiveProducers = 0;
    
    public Producer(String name , Queue sharedQueue,int maxItemsToProduce )
    {
        this.maxItemsToProduce=maxItemsToProduce;
        this.sharedQueue=sharedQueue;
        this.name=name;
    }
    
    @Override
    public void run() 
    {
        for(int i=0 ; i<maxItemsToProduce ; i++)
        {
            int var=r.nextInt(45);
            try {
                sharedQueue.addItem(var);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Producer [ " +name+" ]"+" created: "+var+" item ");
        }
    
    
    }
    public static synchronized int getNumberOfActiveProducers()
    {
        return numberOfActiveProducers;
    }
    private static synchronized void incrementNumberOfActiveProducers()
    {
        numberOfActiveProducers++;
    }
}
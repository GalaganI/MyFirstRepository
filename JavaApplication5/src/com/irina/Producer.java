/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irina;

import java.util.Random;




/**
 *
 * @author Irina
 */
public class Producer implements Runnable{
    
    private String name;
    
    
    private final Queue sharedQueue;
    private int maxItemsToProduce;
    private static int numberOfActiveProducers = 0;
    private static final Object numberOfActiveProducersLock = new Object();
    
    public Producer(String name , Queue sharedQueue,int maxItemsToProduce )
    {
        this.maxItemsToProduce=maxItemsToProduce;
        this.sharedQueue=sharedQueue;
        this.name=name;
    }
    
    @Override
    public void run() 
    {
       synchronized (numberOfActiveProducersLock) {
			numberOfActiveProducers++;
		}
        Random r =new Random();
        try{
                for(int i=0 ; i<maxItemsToProduce ; i++)
                {
                    if(sharedQueue.isFull()){
                        break; //stop producing when queue is full
                    }

                             int producedItem=r.nextInt(45);
                             System.out.println("producer['" + name + "'] >>> producing '" + producedItem + "' (producedCount: " + i + ")");

                             sharedQueue.addItem(producedItem);

                             Thread.sleep(r.nextInt(50));
                }
            } catch (InterruptedException ex) {}
               
        synchronized (numberOfActiveProducersLock) {
			numberOfActiveProducers--;
		}
            }
    
    public static int getNumberOfActiveProducers()
    {
        synchronized(numberOfActiveProducersLock)
        {
        return numberOfActiveProducers;
        }
    }
    
}
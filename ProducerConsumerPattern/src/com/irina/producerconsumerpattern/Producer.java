
package com.irina.producerconsumerpattern;

import java.util.Random;

/**
 *
 * @author Irina
 */
public class Producer implements Runnable {
     
     private String name;
     private QueueOfItems scheduledQueue ;
     private int totalNumberOfItemsToProduce;
     
     private static final Object numberOfActiveProducerLocks = new Object();
     private static int numberOfRunningProducers =0 ;
     
     
     
     public Producer(String name ,QueueOfItems scheduledQueue , int totalNumberOfItemsToProduce )
     {
       this.scheduledQueue=scheduledQueue;
       this.name=name;
       this.totalNumberOfItemsToProduce=totalNumberOfItemsToProduce;
     }

    @Override
    public void run() {
        
        synchronized(numberOfActiveProducerLocks){
        numberOfRunningProducers++;
        }
   try{
            
        Random rnd= new Random();
        for(int i=0 ; i<totalNumberOfItemsToProduce ; i++){
          //Check if queue is already full
            if(scheduledQueue.isFull()){
             break;
            }else {
                
             int producedItem = rnd.nextInt(50);
             System.out.println("Producer ["+name+"] produced >>> "+producedItem+" number "+i);
             scheduledQueue.addItem(producedItem);
             Thread.sleep(rnd.nextInt(45));
                   }
            }
     }catch(InterruptedException ex){
                System.out.println("Producer "+name+" process was killed");
            }
       synchronized(numberOfActiveProducerLocks){
          numberOfRunningProducers--;
       }     
            
   }
 public String getName(){
   
     return this.name;
 }
 public static int getNumberOfRunningProducers(){
   
     synchronized(numberOfActiveProducerLocks){
     return numberOfRunningProducers;
   }
 }
}
     
     


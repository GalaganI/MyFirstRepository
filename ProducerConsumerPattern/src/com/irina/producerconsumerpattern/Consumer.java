
package com.irina.producerconsumerpattern;

import java.util.Random;

/**
 *
 * @author Irina
 */
public class Consumer implements Runnable {

    private QueueOfItems scheduledQueue ;
    private String name;
    private int totalConsumedItemsCounter = 0;

    public Consumer(String name , QueueOfItems scheduledQueue ){
        this.name=name;
        this.scheduledQueue=scheduledQueue;
    }
    
    public boolean isAnyProducerAlive() {
        return Producer.getNumberOfRunningProducers() > 0;
    }
    
    @Override
    public void run() {
        
        try{
            Random rnd=new Random();
            while(true)
            {
                Integer item=scheduledQueue.retrieveItem();
                if(item==null){
                    //There is nothing to consume , producer is too slow or even dead
                    if(!isAnyProducerAlive()){
                        break;// there is no alive producers
                    }
                }else{
                    //We consume successfully an item
                    totalConsumedItemsCounter++;
                    System.out.println("Consumer ["+name+"] consumed <<< '"+item+"'");
          
                }
                Thread.sleep(rnd.nextInt(50));
            }
        }catch(InterruptedException e){
            System.out.println("Consumer process "+name+" is killed");
        }
        //Print statistics
        System.out.println("Number of items consumed by process "+name+" is # "+totalConsumedItemsCounter);
    }
    public int getTotalConsumedItemsCounter(){
        
        return this.totalConsumedItemsCounter;
    }
}

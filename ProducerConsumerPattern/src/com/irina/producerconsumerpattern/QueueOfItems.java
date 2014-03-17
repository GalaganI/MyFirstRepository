
package com.irina.producerconsumerpattern;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Irina
 */
public class QueueOfItems {
    
    private Queue<Integer> scheduledQueue = new LinkedList<Integer>();
    private int maxSize ;
   
   public QueueOfItems(int maxSize){
       
       this.maxSize=maxSize;
   }
   public synchronized boolean isFull() {
        
       return scheduledQueue.size()>=maxSize;
    }

    public synchronized void addItem(int producedItem) {
         
        if(scheduledQueue.size()>=getMaxSize()){
             //This should not occur probably there is a bug
             throw new RuntimeException("Warehouse failure. Could not add item. Warehouse is full");
         } 
        scheduledQueue.add(producedItem);
    }
    public synchronized Integer retrieveItem(){
        
        if(scheduledQueue.isEmpty())
            return null;
        return scheduledQueue.remove();
    }

    public int getMaxSize() {
        
        return this.maxSize;
    }
    
}

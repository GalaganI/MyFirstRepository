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
public class Consumer implements Runnable{
    
    private final Queue sharedQueue ;
    private String name ;
    
    private static Random rnd = new Random();
    
    public Consumer(String name , Queue sharedQueue)
    {
        this.name=name;
        this.sharedQueue=sharedQueue;
    }

    @Override
    public void run() {
        
        int totalConsumedByThisConsumer=0;
        
        try{
                while(true)
                {       
                        Integer item =sharedQueue.retreiveItem();
                        if(item==null)
                        {
                            // nothing to consume. Queue is empty. Too slow producer or producer is dead
                            if (Producer.getNumberOfActiveProducers() <= 0) {
						break; // no active producers. Let's finish this consumer
                            }
                        }else {
					// We consumed successfully a item
					totalConsumedByThisConsumer++;
					System.out.println("Consumer '" + name + "' consume <<< " + item);
			       }

				Thread.sleep(rnd.nextInt(50));
	          }
               

		} catch (InterruptedException ex) {
			System.out.println("Consumer '" + name + "' process killed");
		}

		// Print statistics
		System.out.println("### Consumer '" + name + "' consumed " + totalConsumedByThisConsumer + " items");
    }
    
}

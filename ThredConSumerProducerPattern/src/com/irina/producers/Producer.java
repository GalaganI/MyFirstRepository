package com.irina.producers;

import java.util.Random;

import com.irina.consumerproducerpattern.QueueExample;

public class Producer implements Runnable {

//	private final long TIME_TO_WAIT=10000;
	
	private QueueExample pQueue ;
	private Random rnd= new Random();
	
	public Producer(QueueExample pQueue){
		this.pQueue=pQueue;
	}
	
	@Override
	public void run() {
		
		int itemIndex=0;
		
		while(true)
		{      
			int addedItem=rnd.nextInt(50);
			try {
			
				pQueue.addItem(addedItem);
				System.out.println("Thread '"+Thread.currentThread().getName()+"' produce item ["+(itemIndex++)+"]="+addedItem);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			   }
			
		}
	}
	

}

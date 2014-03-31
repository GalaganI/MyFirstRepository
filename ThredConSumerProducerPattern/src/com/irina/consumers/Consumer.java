package com.irina.consumers;

import java.util.Random;

import com.irina.consumerproducerpattern.QueueExample;

public class Consumer implements Runnable {
	
	private final int MAX_CONSUMED = 20;
	private final int MIN_CONSUMED = 10;
	
	private QueueExample cQueue ;
	private Random rnd = new Random();
	private int itemsNumberToConsume ;
	private int numberOfConsumedItems=0;
	
	public Consumer(QueueExample cQueue){
		this.cQueue=cQueue;
	}
	@Override
	public void run() {
		
		itemsNumberToConsume=rnd.nextInt((MAX_CONSUMED-MIN_CONSUMED)+1)+MIN_CONSUMED;
		
		try {
			for(int i=0 ; i<itemsNumberToConsume ; i++){
				System.out.println("Thread '"+Thread.currentThread().getName()+"' consumed item ["+i+"]="+cQueue.retrieveItem());
				numberOfConsumedItems++;
			}
		} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("Consumer ["+Thread.currentThread().getName()+"] consumed #"+numberOfConsumedItems+", when supposed to "+itemsNumberToConsume);
		Thread.yield();
	}
	
}

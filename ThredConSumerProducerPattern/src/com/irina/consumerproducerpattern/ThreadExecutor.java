package com.irina.consumerproducerpattern;

import com.irina.consumers.Consumer;
import com.irina.producers.Producer;

public class ThreadExecutor {

	public static void main(String[] args) {
		
		QueueExample mQueue=new QueueExample();
		
		Thread producer=new Thread(new Producer(mQueue) , "Producer");
		Thread consumer1=new Thread(new Consumer(mQueue),"Consumer 1 ");
		Thread consumer2=new Thread(new Consumer(mQueue),"Consumer 2 ");
		
		consumer1.start();
		consumer2.start();
		producer.start();
		
	}

}

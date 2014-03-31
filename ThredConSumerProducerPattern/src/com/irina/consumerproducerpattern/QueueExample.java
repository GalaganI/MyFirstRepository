package com.irina.consumerproducerpattern;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	
	private Queue<Integer> queue = new LinkedList<>() ;
	private  boolean needItemflag=false ;
	
	public synchronized int retrieveItem() throws InterruptedException{
		
		if(queue.isEmpty()){
			this.needItemflag=true;
			wait();
		}
		notifyAll();
		return queue.remove();
	}
	
	
	public synchronized void addItem(int item) throws InterruptedException{
		
		if(!needItemflag)
			wait();

		queue.add(item);
		this.needItemflag=false;
		notifyAll();
	}
	
	
	
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irina;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author SERGIU
 */
public class Queue  {
    
        private int maxSize;
	private BlockingQueue<Integer> items = new LinkedBlockingQueue<Integer>();

	public Queue(int maxSize) {
		this.maxSize = maxSize;
	}

	public  boolean isFull() {
		return items.size() >= getMaxSize();
	}

	public  void addItem(int item) throws InterruptedException {

//		if (items.size() >= getMaxSize()) {
//			// Normally this should not occur. if yes - it's a bug
//			throw new RuntimeException("Queue failure. Could not add item. Queue is full");
//		}

		items.put(item);
	}

	public  Integer retreiveItem() throws InterruptedException {
		if (items.isEmpty()) {
			return null;
		}

		return items.take();
	}

	public int getMaxSize() {
		return maxSize;
	}

}

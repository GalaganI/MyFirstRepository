/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irina;

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

	public  synchronized void addItem(int item) throws InterruptedException {

		if (isFull()) {
			// Normally this should not occur. if yes - it's a bug
			throw new RuntimeException("Queue failure. Could not add item. Queue is full");
		}

		items.put(item);
	}

	public  synchronized Integer retreiveItem() throws InterruptedException {
		if (items.isEmpty()) {
			return null;
		}

		return items.take();
	}

	public int getMaxSize() {
		return maxSize;
	}

}

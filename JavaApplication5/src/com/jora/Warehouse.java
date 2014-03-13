package com.jora;

import java.util.LinkedList;
import java.util.Queue;

public class Warehouse {

	private int maxSize;

	private Queue<Integer> items = new LinkedList<Integer>();

	public Warehouse(int maxSize) {
		this.maxSize = maxSize;
	}

	public synchronized boolean isFull() {
		return items.size() >= getMaxSize();
	}

	public synchronized void addItem(int item) {

		if (items.size() >= getMaxSize()) {
			// Normally this should not occur. if yes - it's a bug
			throw new RuntimeException("Warehouse failure. Could not add item. Warehouse is full");
		}

		items.add(item);
	}

	public synchronized Integer retreiveItem() {
		if (items.isEmpty()) {
			return null;
		}

		return items.remove();
	}

	public int getMaxSize() {
		return maxSize;
	}

}

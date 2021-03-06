package com.jora;

public class Main {
	private static final int MAX_SIZE = 10;
	private static final int TOTAL_ITEMS_COUNT = 20;

	public static void main(String args[]) {

		Warehouse warehouse = new Warehouse(MAX_SIZE);

		new Thread(new Producer("producer1", warehouse, TOTAL_ITEMS_COUNT)).start();
		new Thread(new Consumer("consumer1", warehouse)).start();
		new Thread(new Consumer("consumer2", warehouse)).start();
	}
}

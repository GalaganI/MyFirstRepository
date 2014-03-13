package com.jora;

import java.util.Random;

public class Producer implements Runnable  {

	private String name;
	private int maxItemsToProduce;
	private Warehouse warehouse;

	private static Object numberOfActiveProducersLock = new Object();
	private static int numberOfActiveProducers = 0;



	public Producer(String name, Warehouse warehouse, int maxItemsToProduce) {
		this.name = name;
		this.warehouse = warehouse;
		this.maxItemsToProduce = maxItemsToProduce;
	}

	@Override
	public void run() {

		synchronized (numberOfActiveProducersLock) {
			numberOfActiveProducers++;
		}

		Random rnd = new Random();

		try {

			for (int i=1; i<=maxItemsToProduce; i++) {

				if (warehouse.isFull()) {
					break; //stop producing when warehouse is full
				}

				int producedItem = rnd.nextInt(100);
				System.out.println("producer['" + name + "'] >>> producing '" + producedItem + "' (producedCount: " + i + ")");
	
				warehouse.addItem(producedItem);
	
				Thread.sleep(rnd.nextInt(50));
			}

		} catch (InterruptedException ex) {
			System.out.println("Producer '" + name + "' process killed");
		}

		synchronized (numberOfActiveProducersLock) {
			numberOfActiveProducers--;
		}
	}

	public String getName() {
		return name;
	}

	public static int getNumberOfActiveProducers() {
		synchronized (numberOfActiveProducersLock) {
			return numberOfActiveProducers;
		}
	}
}

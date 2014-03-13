package com.jora;

import java.util.Random;

public class Consumer implements Runnable {

	private String name;
	private Warehouse warehouse;

	private static Random rnd = new Random();

	public Consumer(String name, Warehouse warehouse) {
		this.name = name;
		this.warehouse = warehouse;
	}

	@Override
	public void run() {

		int totalConsumedByThisConsumer = 0;

		
		try {

			while (true) {
				Integer item = warehouse.retreiveItem();
				if (item == null) {
					// nothing to consume. warehouse is empty. Too slow producer or producer is dead
					if (Producer.getNumberOfActiveProducers() <= 0) {
						break; // no active producers. Let's finish this consumer
					}

				} else {
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

	public String getName() {
		return name;
	}
}

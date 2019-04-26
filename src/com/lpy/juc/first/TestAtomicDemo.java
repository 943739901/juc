package com.lpy.juc.first;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicDemo {
	public static void main(String[] args) {
		AtomicDemo atomicDemo = new AtomicDemo();
		new Thread(atomicDemo).start();
		
		for (int i = 0; i < 10000; i++) {
			new Thread(atomicDemo).start();
		}
	}
}

class AtomicDemo implements Runnable {
	
	private int serialNumber = 0;
	//private AtomicInteger serialNumber = new AtomicInteger(0);

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
		
		System.out.println("serialNumber=" + getSerialNumber());
	}

	/*public int getSerialNumber() {
		return serialNumber.getAndIncrement();
	}*/
	
	public int getSerialNumber() {
		return serialNumber++;
	}
}

package com.lpy.juc.first;

public class TestCompareAndSwap {
	public static void main(String[] args) {
		CompareAndSwap compareAndSwap = new CompareAndSwap();
		
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int expectedValue = compareAndSwap.getValue();
					boolean compareAndSet = compareAndSwap.compareAndSet(expectedValue, (int)(Math.random()*101));
					System.out.println("value:" + compareAndSwap.getValue() + "success:" + compareAndSet);
				}
			}).start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("final:" + compareAndSwap.getValue());
	}
}

class CompareAndSwap {
	private int value;

	public synchronized int getValue() {
		return value;
	}
	
	public synchronized int compareAndSwap(int expectedValue, int newValue) {
		int oldValue = value;
		
		if(oldValue == expectedValue) {
			this.value = newValue;
		}
		return value;
	}
	
	public synchronized boolean compareAndSet(int expectedValue, int newValue) {
		return expectedValue == compareAndSwap(expectedValue, newValue);
	}
}

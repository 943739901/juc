package com.lpy.juc.first;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(50);
		LatchDemo latchDemo = new LatchDemo(latch);
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 50; i++) {
			new Thread(latchDemo).start();
		}
		
		try {
			latch.wait();
		} catch (InterruptedException e) {
		}
		
		long end = System.currentTimeMillis();
		System.out.println("共花费"+(end-start));
	}
}

class LatchDemo implements Runnable {
	
	private CountDownLatch latch;
	
	public LatchDemo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 50000; i++) {
				if(i%2 == 0) {
					System.out.println(i);
				}
			}
		} finally {
			latch.countDown();
		}
	}
}


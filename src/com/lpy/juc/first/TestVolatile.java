package com.lpy.juc.first;

/**
 * @author Administrator
 * https://www.cnblogs.com/ccfdod/p/6392343.html
 */
public class TestVolatile {
	public static void main(String[] args) {
		ThreadDemo threadDemo = new ThreadDemo();
		new Thread(threadDemo).start();
		
		while (true) {
			//System.out.println("我是谁");
			if(threadDemo.isFlag()) {
				System.out.println("----------------");
				break;
			}
			
		}
	}
}

class ThreadDemo implements Runnable {
	
	private boolean flag = false;
	
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
		
		flag = true;
		
		System.out.println("flag=" + isFlag());
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}

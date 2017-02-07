package com.jesson.test;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread {
	
	private Counter counter;
	private CountDownLatch countDownLatch;
	
	public MyThread(CountDownLatch countDownLatch,Counter counter){
		this.counter = counter;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			counter.addCount();
		}
		countDownLatch.countDown();
	}

}

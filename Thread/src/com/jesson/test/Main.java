package com.jesson.test;

import java.util.concurrent.CountDownLatch;

public class Main {
	

	public static void main(String[] args) {
		
		int threadCount = 1000;
		Counter counter = new Counter();
		CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		
		for (int i = 0; i < threadCount; i++) {
			Thread thread = new Thread(new MyThread(countDownLatch,counter));
			thread.start();
		}
		
		try {
			countDownLatch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(counter.getCount());
	}

}

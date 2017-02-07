package com.jesson.test;

public class Counter  implements Runnable{
	
	private long count = 0;

	public long getCount() {
		return count;
	}
	
	public synchronized void addCount(){
		count ++;
	}

	public synchronized void test(){
		System.out.println(1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(2);
	}
	
	@Override
	public void run() {
		test();
		
	}
	static class Main{
		public static void main(String[] args) {
			Counter counter = new Counter();
			for (int i = 0; i < 3; i++) {
				Thread thread = new Thread(counter);
				thread.start();
			}
		}
	}


}

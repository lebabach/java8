package jdk8;

class TableTEst {

	void printTable(int n) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}// end of the method
}

class MyThread1 extends Thread {
	TableTEst t;

	MyThread1(TableTEst t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}

}

class MyThread2 extends Thread {
	TableTEst t;

	MyThread2(TableTEst t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}

class CounterThread extends Thread {

	protected Counter counter = null;

	public CounterThread(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			counter.add(i);
		}
	}
}

class Counter {

	long count = 0;

	public synchronized void add(long value) {
		this.count += value;
		System.out.println(this.count);
	}
}

public class TestSynchronizedBlock1 {
	public static void main(String args[]) {
		/*
		 * Table obj = new Table();// only one object MyThread1 t1 = new
		 * MyThread1(obj); MyThread2 t2 = new MyThread2(obj); t1.start();
		 * t2.start();
		 */

		Counter counter = new Counter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);

		threadA.start();
		threadB.start();
	}
}

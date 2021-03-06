package com.lsylvanus.the;

public class ExtendThread {

	public static void main(String[] args) {
		new ExtendThreadNewThread();

		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Main thread: " + i);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Main thread exiting.");
	}
}

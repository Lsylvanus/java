package com.lsylvanus.the;

//通过继承 Thread 创建线程
public class ExtendThreadNewThread extends Thread {

	public ExtendThreadNewThread() {
		// 创建第二个线程
		super("Demo Thread");
		System.out.println("Child thread: " + this);
		start(); // 开始线程
	}

	// 第二个线程入口
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child thread: " + i);
				// 让线程休眠一会
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrupted.");
		}
		System.out.println("Exiting child thread.");
	}
}

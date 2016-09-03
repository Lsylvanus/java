package com.lsylvanus.the;

public class NewThread implements Runnable{

	// 创建一个新的线程
	Thread t;

	public NewThread() {
		// 创建第二个新线程
		t = new Thread(this, "Demo Thread");
		System.out.println("Child thread: " + t);
		t.start();
	}

	@Override
	public void run() {
		// 第二个线程入口
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child Thread: " + i);
				// 暂停线程
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrupted.");
		}
		System.out.println("Exiting child thread.");
	}
}

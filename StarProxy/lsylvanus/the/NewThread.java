package com.lsylvanus.the;

public class NewThread implements Runnable{

	// ����һ���µ��߳�
	Thread t;

	public NewThread() {
		// �����ڶ������߳�
		t = new Thread(this, "Demo Thread");
		System.out.println("Child thread: " + t);
		t.start();
	}

	@Override
	public void run() {
		// �ڶ����߳����
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child Thread: " + i);
				// ��ͣ�߳�
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrupted.");
		}
		System.out.println("Exiting child thread.");
	}
}

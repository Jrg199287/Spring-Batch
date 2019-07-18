
package com.jrg.demo2;
class ThreadTrain1 implements Runnable {
	// 总共有一百张火车
	private int train1Count = 100;
    private Object oj =new Object();
	@Override
	public void run() {
		// 为了能够模拟程序一直在抢票的话。 where
		while (train1Count > 0) {
			try {Thread.sleep(50);} catch (Exception e) {// TODO: handle exception
			}// 出售火車票
			sale();
		}
	}
	public void sale() {
		//同步代码块 synchronized  包裹需要线程安全的问题。
		synchronized (oj) {
			if(train1Count>0){
				System.out.println(Thread.currentThread().getName()+ ",出售第" + (100 - train1Count + 1) + "票");
				train1Count--;
			}
		}
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		/*只有同时共享同一个全局变量train1Count才能叫作抢票*/
		ThreadTrain1 threadTrain1 = new ThreadTrain1();
		//这两个线程只能对同一个线程threadTrain1操作才能叫做抢票
		Thread t1 = new Thread(threadTrain1,"窗口①");
		Thread t2 = new Thread(threadTrain1,"窗口②");
		t1.start();
		t2.start();
	}

}

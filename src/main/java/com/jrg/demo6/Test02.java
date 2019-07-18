package com.jrg.demo6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test02 extends Thread {
	private Lock lock = new ReentrantLock();
	public void get() {
		lock.lock();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(Thread.currentThread().getId() + ",get");
		set();
		lock.unlock();
	}
	public void set() {
		lock.lock();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(Thread.currentThread().getId() + ",set");
		lock.unlock();
	}
	@Override
	public void run() {
		get();
	}
	public static void main(String[] args) {
		Test02 ss = new Test02();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
	}

}

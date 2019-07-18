
package com.jrg.demo5;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Parent extends  Thread {
	Semaphore wc;
	String name;

	public Parent(Semaphore wc, String name) {
		this.wc = wc;
		this.name = name;
	}

	@Override
	public void run() {
		// 获取到资源，减去1
		int availablePermits = wc.availablePermits();
		if (availablePermits > 0) {
			System.out.println(name + "天主我也，我有茅坑啦!!");
		} else {
			System.out.println(name + "怎么没有茅坑了.....");
		}
		try {
			wc.acquire();
			System.out.println(name+"终于能上厕所了，爽!!!");
			Thread.sleep(new Random().nextInt(1000)); // 模拟上厕所时间。
			System.out.println(name+"厕所终于上完啦!");
		} catch (InterruptedException e) {

		}finally {
			//释放茅坑
			wc.release();
		}

	}
}
public class Test004 {
	public static void main(String[] args) throws InterruptedException {
//		// 最多支持多个资源访问
//		Semaphore semaphore = new Semaphore(5);
//		// 获取到资源，减去1
//		semaphore.availablePermits();
//		// 释放资源
//		semaphore.release();
		Semaphore semaphore = new Semaphore(3);
		for (int i = 1; i <=10; i++) {
			new Parent(semaphore,"第"+i+"个"+",").start();
		}
	}

}

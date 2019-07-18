
package com.jrg.demo5;

import java.util.concurrent.CyclicBarrier;

class Writer extends Thread {
	CyclicBarrier cyclicBarrier;
	public Writer(CyclicBarrier cyclicBarrier){
		this.cyclicBarrier=cyclicBarrier;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始写入数据...");
		try {
			// 模拟耗时时间
			Thread.sleep(30);

			// 执行并行执行成功
			System.out.println(Thread.currentThread().getName() + "写入数据成功...");
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName() + "所以数据执行完毕...");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
public class Test003 {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier=	new CyclicBarrier(5);
		for (int i = 0; i < 5; i++) {
			new Writer(cyclicBarrier).start();
		}
	}

}

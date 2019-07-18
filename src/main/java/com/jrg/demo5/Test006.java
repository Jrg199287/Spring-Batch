
package com.jrg.demo5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ProducerThread extends Thread {
	private BlockingQueue queue;
	private volatile boolean flag = true;
	private static AtomicInteger count = new AtomicInteger();
	ProducerThread(BlockingQueue blockingQueue) {
		this.queue = blockingQueue;
	}
	@Override
	public void run() {
		System.out.println("生产者线程启动...");
		try {
			while (flag) {
				System.out.println("正在生产队列");
				String data = count.incrementAndGet() + "";
				// 添加队列
				boolean offer = queue.offer(data);
				if (offer) {
					System.out.println("生产者添加队列" + data + "成功!");
				} else {
					System.out.println("生产者添加队列" + data + "失败!");
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("生产者线程停止...");
		}
	}

	public void stopThread() {
		this.flag = false;
	}

}

class ConsumerThread extends Thread {
	private BlockingQueue queue;
	private volatile boolean flag = true;
	ConsumerThread(BlockingQueue blockingQueue) {
		this.queue = blockingQueue;
	}
	@Override
	public void run() {
		System.out.println("消费者线程启动....");
		try {
			while (flag) {
				// 获取完毕，队列会删除掉
				String data = (String) queue.poll(2, TimeUnit.SECONDS);
				if (data != null) {
					System.out.println("消费者获取 data:" + data + "成功...");
				} else {
					System.out.println("消费者获取 data:" + data + "失敗..");
					//this.flag = false;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("消费停止....");
		}
	}
	public void stopThread() {
		this.flag = false;
	}
}

public class Test006 {
	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
		ProducerThread p1 = new ProducerThread(queue);
		ProducerThread p2 = new ProducerThread(queue);
		ConsumerThread c1 = new ConsumerThread(queue);
		p1.start();
		p2.start();
		c1.start();

		// 执行10s
		Thread.sleep(10 * 1000);
		p1.stopThread();
		p2.stopThread();
		c1.stopThread();
	}

}
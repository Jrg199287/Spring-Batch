
package com.jrg.demo5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

public class Test005 {

	public static void main(String[] args) throws InterruptedException {
		// 无界
		ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
		concurrentLinkedDeque.offer("张三");
		concurrentLinkedDeque.offer("李四");
		System.out.println(concurrentLinkedDeque.size());
		System.out.println(concurrentLinkedDeque.poll());
		//System.out.println(concurrentLinkedDeque.peek());
		System.out.println(concurrentLinkedDeque.size());
//		ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
//		arrayBlockingQueue.add("张三");
//		arrayBlockingQueue.add("李四");
//		arrayBlockingQueue.add("王武");
//		//可以阻塞的队列
//		boolean offer = arrayBlockingQueue.offer("王麻衣子", 2, TimeUnit.SECONDS);
//		System.out.println(arrayBlockingQueue.size()+"---"+offer);
//		System.out.println(arrayBlockingQueue.poll());
//		System.out.println(arrayBlockingQueue.poll());
//		System.out.println(arrayBlockingQueue.poll());
//		System.out.println(arrayBlockingQueue.poll());
	}

}


package com.jrg.demo4;

import java.util.Map;

class ResNumber {
	public int count = 0;
	public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 0;
		};
	};
	public String getNumber() {
		count = threadLocal.get() + 1;
		threadLocal.set(count);
		return count + "";
	}
	//底层原理的伪代码演示
	Map<Object, Object> map;
	public void set(Integer count) {
		map.put(Thread.currentThread(), count);
	}
	public String get() {
		return (String) map.get(Thread.currentThread());
	}
}
class LocaThreadDemo extends Thread {
	private  ResNumber resNumber;
	public LocaThreadDemo(ResNumber resNumber) {
		this.resNumber = resNumber;
	}
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(getName() + ",number:" + resNumber.getNumber());
		}
	}
}
public class ThreadLocaDemo01 {
	public static void main(String[] args) {
		ResNumber resNumber = new ResNumber();
		LocaThreadDemo t1 = new LocaThreadDemo(resNumber);
		LocaThreadDemo t2 = new LocaThreadDemo(resNumber);
		LocaThreadDemo t3 = new LocaThreadDemo(resNumber);
		t1.start();
		t2.start();
		t3.start();
	}

}


package com.jrg.demo6;

import java.util.concurrent.atomic.AtomicInteger;

public class Test003 {

	public static void main(String[] args) {
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();// I++
	}

}

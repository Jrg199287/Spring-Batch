
package com.itmayiedu;

//保证在jvm中只能有一个实例
class Singleton {
	//static private Singleton singleton;
   ///饿韩式 当class文件被加载的时候，就初始化对象
	static private Singleton singleton = new Singleton();
	// 懒韩式 当需要的时候才会去创建对象
	private Singleton() {

	}

	//饿汉式
	 static public Singleton Singleton2(){
	    	 return singleton;
	    }
	// 保证返回一个实例  只能运行 有一个线程访问getSingleton 方法
	static public  Singleton getSingleton() {
		if (singleton == null) {// 第一层上锁
			synchronized (Singleton.class) {
				if(singleton==null) // 第二层上锁  双重检验锁
				singleton = new Singleton();
			}
		}
		//当对象不是Null时候不用考虑线程安全了
		return singleton;
	}
}

public class Test004 {
	public static void main(String[] args) {
		Singleton s1 = Singleton.Singleton2();
		Singleton s2 = Singleton.Singleton2();
		System.out.println(s1 == s2);
	}

}

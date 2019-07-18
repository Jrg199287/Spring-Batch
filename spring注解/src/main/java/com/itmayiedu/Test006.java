package com.itmayiedu;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
interface Hose {
	void maifang();
}
class YuShengJun implements Hose {
	@Override
	public void maifang() {
		System.out.println("我是余胜军，终于可以买房啦!!!");
	}
}
// 静态代理
class Proxy implements Hose {
	// 代理对象
	private YuShengJun yuShengJun;
	public Proxy(YuShengJun yuShengJun) {
		this.yuShengJun = yuShengJun;
	}
	@Override
	public void maifang() {
		System.out.println("我是中介,你买房开始交给我啦!!!");
		yuShengJun.maifang();
		System.out.println("我是中介,你买房开结束啦!!!");
	}
}
// jdk动态代理
class JdkProxy implements InvocationHandler {
	private Object tarjet;
	JdkProxy(Object tarjet) {
		this.tarjet = tarjet;
	}
	@Override
	public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) throws Throwable {
		System.out.println("我是中介,你买房开始交给我啦!!!");
		Object invoke = paramMethod.invoke(tarjet, paramArrayOfObject);
		System.out.println("我是中介,你买房开结束啦!!!");
		return invoke;

	}
}
 //cglib 动态代理
class Cglib implements MethodInterceptor{
	@Override
	public Object intercept(Object oj, Method method, Object[] arrays, MethodProxy methodProxy) throws Throwable {
		System.out.println("我是中介,你买房开始交给我啦!!!");
		Object invokeSuper = methodProxy.invokeSuper(oj, arrays);
		System.out.println("我是中介,你买房开结束啦!!!");
		 return invokeSuper;  
		    
	}
}
public class Test006 {
	public static void main(String[] args) {
//		Hose hose = new Proxy(new YuShengJun());
//		hose.maifang();
		YuShengJun yuShengJun = new YuShengJun();
//		JdkProxy jdkProxy = new JdkProxy(yuShengJun);
//		Hose hose = (Hose) java.lang.reflect.Proxy.newProxyInstance(yuShengJun.getClass().getClassLoader(), yuShengJun.getClass().getInterfaces(), jdkProxy);
//		hose.maifang();
		Cglib cglib = new Cglib();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(YuShengJun.class);
		enhancer.setCallback(cglib);
		Hose hose = (Hose) enhancer.create();
		hose.maifang();
		
	}
}

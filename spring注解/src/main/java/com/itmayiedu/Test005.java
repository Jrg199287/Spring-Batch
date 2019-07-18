
package com.itmayiedu;

interface Car {

	void run();
}

class AoDi implements Car {

	@Override
	public void run() {
		System.out.println("我是奥迪汽车---我是奥迪A6l");
	}

}

class BenChi implements Car {

	@Override
	public void run() {
		System.out.println("我是奔驰汽车----我是奔驰E级");
	}

}

// 奔驰工厂
class BenChiFatory {
	static public Car createCar() {
		return new BenChi();
	}
}

class AoDiFatory {
	static public Car createCar() {
		return new AoDi();
	}
}

class CarFatory {

	static public Car createCar(String name) {
		Car car = null;
		switch (name) {
		case "奥迪":
			car = new AoDi();
			break;
		case "奔驰":
			car = new BenChi();
			break;
		default:
			break;
		}
		return car;

	}
}

public class Test005 {
	public static void main(String[] args) {
		Car car = BenChiFatory.createCar();
		car.run();
		// Car car = CarFatory.createCar("奔驰");
		// car.run();
	}
}

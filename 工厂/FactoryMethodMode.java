package test;
/**
 * 工厂方法模式实例。
 * 相比简单工厂模式，工厂方法模式去掉了工厂的静态属性，使其可以被子类继承, 增加新产品时
 * 只需要再增加一个工厂子类。
 * @author fancoo
 *
 */

//抽象产品角色
abstract class Apple {
	public Apple() {
		
	}
}

//具体产品角色
class iPhone extends Apple {
	public iPhone() {
		System.out.println("iPhone 7 is producing...");
	}
}

class Mac extends Apple {
	public Mac() {
		System.out.println("Macbook Pro is producing...");
	}
}

//创建工厂类
interface Factory {
	Apple createAppleProduct();
}

class iPhoneFactory implements Factory {
	
	@Override
	public iPhone createAppleProduct() {
		return new iPhone();
	}
}

class MacFactory implements Factory {
	
	@Override
	public Mac createAppleProduct() {
		return new Mac();
	}
}

public class FactoryMethodMode {
	public static void main(String[] args) {
		iPhoneFactory iphonefactory = new iPhoneFactory();
		iPhone iphone7 = iphonefactory.createAppleProduct();
		
		MacFactory macfactory = new MacFactory();
		Mac macbookpro = macfactory.createAppleProduct();
		
	}
}

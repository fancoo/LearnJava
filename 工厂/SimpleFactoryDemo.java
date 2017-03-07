package test;
/**
 * 简单工厂模式实例。
 * 缺陷：
 * 每增加一种产品类型，都要在工厂类中增加相应的创建业务逻辑(此处的case),违反了开闭原则。
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
		System.out.println("iPhone is producing...");
	}
}

class Mac extends Apple {
	public Mac() {
		System.out.println("Mac is producing...");
	}
}

//简单工厂类
class Factory {
	public Apple createAppleProduct(int type) {
		switch (type) {
		
		case 1:
			return new iPhone();
		case 2:
			return new Mac();
		default:
			break;
		}
		return null;
	}
}


//客户类（想要什么就从工厂拿，工厂已经创建好了)
public class SimpleFactoryDemo {
	public static void main(String[] args) {
		Factory factory = new Factory();
		Apple iPhone = factory.createAppleProduct(1);
		Apple Mac = factory.createAppleProduct(2);
	}
}



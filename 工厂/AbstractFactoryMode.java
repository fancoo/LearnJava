package test;
/**
 * 抽象工厂模式。
 * @author fancoo
 */

/********产品类********/

// 屏幕型号
interface Screen {
	
}

class iPhoneScreen implements Screen {
	public iPhoneScreen() {
		System.out.println("5.1 inches screen for iPhone 7!");
	}
}

class MacScreen implements Screen {
	public MacScreen() {
		System.out.println("15.9 inches retina screen for Macbook Pro!");
	}
}

//操作系统
interface OS {
	
}

class iOS implements OS {
	public iOS() {
		System.out.println("The Operating System is iOS 10.");
	}
}

class MacOS implements OS {
	public MacOS() {
		System.out.println("The Operating System is Max OSX");
	}
}

/********工厂类********/

//创建工厂的接口
interface AbstractFactory {
	// 制造屏幕
	public Screen createScreen();
	// 安装操作系统
	public OS installOS();
}

// 为iPhone 7生产配件
class iPhone7Factory implements AbstractFactory {
	
	@Override
	public Screen createScreen() {
		return new iPhoneScreen();
	}
	
	@Override
	public OS installOS() {
		return new iOS();
	}
}

// 为Macbook Pro生产配件
class MBPFactory implements AbstractFactory {
	
	@Override
	public Screen createScreen() {
		return new MacScreen();
	}
	
	@Override
	public OS installOS() {
		return new MacOS();
	}
}

/********客户********/
public class AbstractFactoryMode {
	public static void main(String[] args) {
		// 生产iPhone 7
		iPhone7Factory iphone7factory = new iPhone7Factory();
		iphone7factory.createScreen();
		iphone7factory.installOS();
		
		// 生产Macbook Pro
		MBPFactory mbpfactory = new MBPFactory();
		mbpfactory.createScreen();
		mbpfactory.installOS();
	}
}

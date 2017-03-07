package test;
/**
 * 单例模式实例。
 * @author fancoo
 *
 */

// 懒汉式，线程不安全
class SingletonDemo {
	
	// 定义一个私有的静态全局变量来保存该类的唯一实例
	private static SingletonDemo instance;
	
	private SingletonDemo() {}
	
	public static SingletonDemo getInstance() {
		// 这里可以保证只实例化一次
		if (instance == null) {
			instance = new SingletonDemo();
		}
		return instance;
	}
}

// 懒汉式，线程安全，但不高效，因为任何时候只能有一个线程调用getInstance()方法。
class SingletonDemo2 {
	
	private static SingletonDemo2 instance;
	
	private SingletonDemo2() {}
	
	public static synchronized SingletonDemo2 getInstance() {
		if (instance == null) {
			instance = new SingletonDemo2();
		}
		return instance;
	}
}


/**
 * 双重检验锁(double checked)，一次在同步块内，一次在同步块外。
 * 假设现在有4个线程T1,T2,T3,T4。T1,T2进入了区域(1)，T3,T4还没启动。
 * T1能进入区域(2)创建instance成功，之后T2进入区域(2)，判断非空并出来
 *  此时T3,T4启动了，不会进入区域(1)，且无需等待锁。
 *  
 *  缺点:
 *  语句(1) "instance = new SingletonDemo3();"并非原子操作，它有3步：
 *  1. 给instance分配内存
 *  2. 调用SingletonDemo3的构造函数初始化成员变量
 *  3. 将instance对象指向分配的内存空间
 *  因JVM编译时存在指令重排，其中1,2,3的执行顺序不能保证，如果3在2之前发生，instance不为空。
 *  恰好在此刹那T3启动了，T3执行外层判断，不进入等待锁直接读走了instance，由于还未执行2初始化，于是报错。
 */
class SingletonDemo3 {
	
	private static SingletonDemo3 instance;
	
	private SingletonDemo3() {}
	
	public static SingletonDemo3 getInstance() {
		if (instance == null) {    // 区域(1)
			synchronized (SingletonDemo3.class) {  // 区域(2)
				if (instance == null) {
					instance = new SingletonDemo3(); // 语句(1)
				}
			}
		}
		return instance;
	}
}

/**上一个的改进：instance变量声明成volatile, 它可以禁止指令重排序优化。
 * 
 * volatile的两个作用：
 * 1. 禁止指令重排优化。
 * 2. 所修饰的变量一旦被修改，其他线程立即可见。（但是非原子，因此可用于1读者n写者的场景，例如"游戏退出按钮")
 *
 */
class SingletonDemo4 {
	private volatile static SingletonDemo4 instance; // 声明成volatile
	
	private SingletonDemo4() {}
	
	public static SingletonDemo4 getSingletonDemo4() {
		if (instance == null) {
			synchronized (SingletonDemo4.class) {
				if (instance == null) {
					instance = new SingletonDemo4();
				}
			}
		}
		return instance;
	}
}


/**
 * 饿汉式,单例的实例被声明成static和final，在第一次加载到内存中时会初始化。
 * 
 * 缺点：
 *不是一种懒加载(lazy initlalization),在一些场景中无法使用：
 *譬如Singleton实例的创建时以来参数或者配置文件的，在getInstance()之前必须调用
 */
class SingletonDemo5 {
	// 类加载时就初始化
	private static final SingletonDemo5 instance = new SingletonDemo5();
	
	private SingletonDemo5() {}
	
	public static SingletonDemo5 getInstance() {
		return instance;
	}
}

/**
 * 静态内部类
 * 
 * 这种写法仍然使用JVM本身机制保证了线程安全问题; 由于SingletonHolder是私有的,
 * 除了getInstance()之外没有办法访问它，因此它是懒汉式的;同时也无同步。
 *
 */
class SingletonDemo6 {
	private static class SingletonHolder {
		private static final SingletonDemo6 INSTANCE = new SingletonDemo6();
	}
	private SingletonDemo6() {}
	
	public static final SingletonDemo6 getInstance() {
			return SingletonHolder.INSTANCE;
	}
}


/**
 * 枚举Enum
 * 
 * 枚举直接使用EasySingleton.INSTANCE来访问实例，比调用getInstance()简单
 * 并且线程安全。
 */
enum EasySingleton {
	INSTANCE;
}

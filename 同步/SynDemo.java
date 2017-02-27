
class SOP {
	public static void print(String s) {
		System.out.println(s);
	}
}

class TestThread extends Thread {
	String name;
	SynDemo synDemo;
	public TestThread(String name, SynDemo synDemo) {
		this.synDemo = synDemo;
		this.name = name;
		start();
	}
	@Override
	public void run() {
		synDemo.test(name);
	}
}

/**
 * 对比时可以去掉synchronized再观察输出。使用synchronized的速度更慢
 * 但输出结果有先后次序。
 */
public class SynDemo {
	public synchronized void test(String name) {
		for (int i = 0; i < 10; ++i) {
			SOP.print(name + " :: " + i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				SOP.print(e.getMessage());
			}
		}
	}
	public static void main(String[] args) {
		SynDemo synDemo = new SynDemo();
		new TestThread("Thread 1", synDemo);
		new TestThread("Thread 2", synDemo);
		new TestThread("Thread 3", synDemo);
		new TestThread("Thread 4", synDemo);
	}
}
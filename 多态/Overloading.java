package Override;

/**
 * Created by max371 on 2017/2/21.
 */

/*Override: 外壳不变，核心重写。
class Animal {
    public void move() {
        System.out.println("动物可以移动");
    }
}

class Dog extends Animal {
    public void move() {
        System.out.println("狗可以跑和走");
    }

    public void bark() {
        System.out.println("狗可以吠");
    }
}

public class TestDog {
    public static void main(String args[]) {
        Animal a = new Animal(); //Animal对象
        Animal b = new Dog();
        a.move();
        b.move();
        b.bark(); //编译错误，因为b的引用类型Animal没有bark方法
    }
}*/

/* Super: 直接调用父类方法
class Dog extends Animal {
    public void move() {
        super.move(); // 应用super类的方法
        System.out.println("狗可以跑和走");
    }
}

public class TestDog {
    public static void main(String args[]) {
        Animal b = new Dog(); // Dog对象
        b.move(); // 执行Dog类的方法
    }
}*/

//Overload(重载): 在一个类里方法名字相同而参数不同，返回类型可以
//相同也可以不同。

public class Overloading {
    public int test() {
        System.out.println("test1");
        return 1;
    }

    public void test(int a) {
        System.out.println("test2");
    }

    //以下两个参数类型顺序不同
    public String test(int a, String s) {
        System.out.println("test3");
        return "return test3";
    }

    public String test(String s, int a) {
        System.out.println("test4");
        return "return test4";
    }

    public static void main(String[] args) {
        Overloading o = new Overloading();
        System.out.println(o.test());
        o.test(1);
        System.out.println(o.test(1, "test3"));
        System.out.println(o.test("test4", 1));
    }
}


/**
 * Created by max371 on 2017/2/21.
 */

/*
子类不能继承父类的构造器，但是父类构造器带有参数的，则必须在
子类的构造器中显式地通过super关键字调用。
如果父类有无参构造器，则在子类的构造器中用super调用父类构造器不是必须的。
 */

class SuperClass {
    private int n;
    SuperClass() {
        System.out.println("SuperClass[1]");
    }
    SuperClass(int n) {
        System.out.println("SuperClass(int n):" + n);
        this.n = n;
    }
}

class SubClass extends SuperClass {
    private int n;

    SubClass() {
        super(300);
        System.out.println("SuperClass[2]");
    }

    public SubClass(int n) {
        Systecd ..m.out.println("SubClass(int n):" + n);
        this.n = n;
    }
}

public class TestSuperSub {
    public static void main(String args[]) {
        SubClass sc = new SubClass();
        SubClass sc2 = new SubClass(200);
    }
}
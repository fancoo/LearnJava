/**
 * Created by max371 on 2017/2/21.
 */
public class Polymorphism {
    public static void main(String[] args) {
        show(new Cat());  //以Cat对象调用show方法
        show(new Dog());  //以Dog对象调用show方法

//        Animal a = new Cat(); //向上转型
//        a.eat();              //调用的是Cat的eat
//        Cat c = (Cat)a;       //向下转型
//        c.work();             //调用的是Cat的catchMouse
    }

    public static void show(Animal a) {
        a.eat();  //类型判断
        if (a instanceof Cat) {
            Cat c = (Cat)a;
            c.work();
        }
        else if (a instanceof Dog) {
            Dog c = (Dog)a;
            c.work();
        }
    }
}

abstract class Animal {
    abstract void eat();
}

class Cat extends Animal {
    public void eat() {
        System.out.println("吃鱼");
    }
    public void work() {
        System.out.println("抓老鼠");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("吃骨头");
    }
    public void work() {
        System.out.println("看家");
    }
}

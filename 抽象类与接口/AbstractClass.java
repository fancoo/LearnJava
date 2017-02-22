/**
 * Created by max371 on 2017/2/21.
 */

/*abstract抽象类
抽象类提供了继承的概念，它的出发点就是为了继承，否则它没有任何
存在的意义。所以说定义的抽象类一定是用来继承的。
 */

abstract class Animal {
    public abstract void cry();
}

class Cat extends Animal {
    @Override
    public void cry() {
        System.out.println("猫叫: 喵喵...");
    }
}

class Dog extends Animal {
    @Override
    public void cry() {
        System.out.println("狗叫: 汪汪...");
    }
}



public class AbstractClass {
    public static void main(String[] args) {
        Animal a1 = new Cat();
        Animal a2 = new Dog();

        a1.cry();
        a2.cry();
    }
}

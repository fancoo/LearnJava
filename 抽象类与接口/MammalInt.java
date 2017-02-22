/**
 * Created by max371 on 2017/2/22.
 */
/*
1. 一个类可以同时实现多个接口。
2. 一个类只能继承一个类，但是能实现多个接口。
3. 一个接口能继承另一个接口，这和类之间的继承比较相似。
 */
public class MammalInt implements AnimalInterface {
    public void eat() {
        System.out.println("Mammal eats");
    }

    public void travel() {
        System.out.println("Mammal travels");
    }

    public int noOfLegs() {
        return 0;
    }

    public static void main(String args[]) {
        MammalInt m = new MammalInt();
        m.eat();
        m.travel();
    }
}

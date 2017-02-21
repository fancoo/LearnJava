/**
 * Created by max371 on 2017/2/21.
 */


// 泛型类: 声明方式和非泛型类相似，除了在类名后面添加了类型参数声明部分。

public class Box<T> {
    private T t;
    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("Ringo"));

        System.out.printf("整型值为: %d\n\n", integerBox.get());
        System.out.printf("字符串为: %s\n\n", stringBox.get());
    }
}
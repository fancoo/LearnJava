/**
 * Created by Ringo on 2017/2/21.
 */
public class Generics {
    public static void main(String[] args) {
        Point<Integer, Integer> p1 = new Point<Integer, Integer>();

        p1.setX(10);
        p1.setY(20);
        int x = p1.getX();
        int y = p1.getY();
        System.out.println("This point is:" + x + ", " + y);

        Point<Double, String> p2 = new Point<Double, String>();
        p2.setX(25.4);
        p2.setY("东经180度");
        double m = p2.getX();
        String n = p2.getY();
        System.out.println("This point is:" + m + ", " + n);
    }
}


//class Point {
//    Object x = 0;
//    Object y = 0;
//
//    Object getX() {
//        return x;
//    }
//
//    void setX(Object x) {
//        this.x = x;
//    }
//
//    Object getY() {
//        return y;
//    }
//
//    void setY(Object y) {
//        this.y = y;
//    }
//}

//泛型
class Point<T1, T2> {
    T1 x;
    T2 y;
    T1 getX() {
        return x;
    }
    void setX(T1 x) {
        this.x = x;
    }

    T2 getY(){
        return y;
    }
    void setY(T2 y) {
        this.y = y;
    }
}
package shadowingandhiding;

class A {
    public int i = 10;
}

class B extends A {
    public int i = 90;
}

public class Hiding {
    public static void main(String[] args) {
        A b = new B();
        System.out.println(b.i);
    }
}

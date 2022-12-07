package polymorphism;

import java.util.concurrent.atomic.AtomicInteger;

public class Static {
  /*  double sum(int a, int b) {
        System.out.println("int");
        return a + b;
    }*/

    double sum(double a, double b) {
        System.out.println("double");
        return a + b;
    }

    public static void main(String[] args) {
         Static aStatic = new Static();
         byte a = 12;
         byte b = 45;
         System.out.println(aStatic.sum(a, b));
         System.out.println(aStatic.sum(1D, 2D));

    }
}

class A extends B {

    @Override
    AtomicInteger b() {
        System.out.println("A b");
        return null;
    }
}

class B {
    Number b() {
        System.out.println("B b");
        return 1L;
    }
}
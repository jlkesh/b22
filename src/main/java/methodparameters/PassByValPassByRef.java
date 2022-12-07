package methodparameters;

public class PassByValPassByRef {
    public static void main(String... args) {
        var o = new PassByValPassByRef();
        /*int a = 3;
        o.m(a);
        System.out.println(a);*/
        /*Counter counter = new Counter();
        System.out.println(counter.getI());
        o.m2(counter);
        System.out.println(counter.getI());*/
        Integer a = 123;
        o.m4(a);
        o.m5(new int[]{});
        o.m6();
        System.out.println(a);
    }

    void m5(int[] arr){}
    void m6(int... arr){}

    void m4(int a) {
        a = 90;
    }
    void m3(Integer a) {
        a = 90;
    }

    void m(int a) {
        a = 12;
    }


    void m2(Counter counter) {
        counter = new Counter();
        counter.increment();
    }

}

class Counter {
    int i = 10;

    public void increment() {
        i++;
    }

    public int getI() {
        return i;
    }
}

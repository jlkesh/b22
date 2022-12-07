package innnerclasses;

public class StaticInnerClassTest {
    public static void main(String[] args) {
        // StaticInnerClass.InnerClass innerClass = new StaticInnerClass.InnerClass();

        class A {
            void m1() {
                class AA {
                    int a = 12;

                    void m2() {
                        System.out.println(a);
                        class AAA {
                            int a = 34;
                        }
                        var aa = new AAA();
                        System.out.println(aa.a);
                    }
                }
                var aa = new AA();
                aa.m2();
            }
        }
        var a = new A();
        a.m1();
    }
}

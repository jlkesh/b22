package formatting;

public class MethodHiding {
    public static void main(String[] args) {
        A a = new B();
        a.a();
    }
}

class A {
    static void a() {
        System.out.println("a");
    }
}

class B extends A {

    static void a() {
        System.out.println("b");
    }

}


interface UserDAO{}
interface CommentDAO{}
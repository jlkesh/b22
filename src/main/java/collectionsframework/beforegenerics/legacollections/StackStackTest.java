package collectionsframework.beforegenerics.legacollections;

import java.util.Iterator;

public class StackStackTest {
    public static void main(String[] args) {
        var ss = new StackStack<String>(10);
        ss.push("Java");
        ss.push("Scala");
        ss.push("Python");
        ss.push("Groovy");
        // ss.push(null);
        ss.push("Kotlin");
        // System.out.println(ss.pop());
        // System.out.println(ss.pop());
        // System.out.println(ss.pop());
        // System.out.println(ss.pop());
//        System.out.println(ss);
        //ss.forEach(System.out::println);
        /*for (String s : ss) {
            System.out.println(s);
        }*/
        // Iterator<String> iterator = ss.iterator();
        // while (iterator.hasNext()) {
        //     System.out.println(iterator.next());
        // }
        // ss.iterator().forEachRemaining(System.out::println);
    }
}

package collectionsframework.beforegenerics;

import java.util.ArrayList;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class ArrayListClassTest {
    public static void main(String[] args) {

        var a = new ArrayList<Integer>();

        a.add(12);
        a.add(32);

        var b = new ArrayList<Integer>(a);
        b.add(46);
        b.add(46);
        b.add(46);
        b.add(46);
        // b.clear();// do not use this method
        // use this b = new ArrayList<>(); instead

        System.out.println(b.contains(32));
        // b.ensureCapacity(40);

        // System.out.println(b);
        // b.removeAll(a);

        System.out.println("b = " + b);
        IntFunction<Integer[]> intFunction = value -> new Integer[value];
        b.toArray(Integer[]::new);
        b.trimToSize();
        /*
        Predicate<Integer> integerPredicate = i -> i.equals(46);
        b.removeIf(integerPredicate);
        System.out.println("b = " + b);
        */

    }
}

package collectionsframework.beforegenerics.iterators;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListIeratorClassTest {
    public static void main(String[] args) {
         var languages = new CopyOnWriteArrayList<String>();
//        var languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("Scala");
        languages.add("Python");
        languages.add("Kotlin");
        languages.add("Go");
        languages.add("Ruby");
        var listIterator = languages.listIterator(languages.size());
        //  12   4    6     8    9     0
        //                             ^
        // listIterator.next();
        while (listIterator.hasPrevious()) {
            String previous = listIterator.previous();
            if (previous.equals("Java")) {
                listIterator.add("Pascal");
                listIterator.add("Delphi");
                languages.add("Pascal");
            }
            System.out.println(previous);
        }
        System.out.println(languages);
    }
}

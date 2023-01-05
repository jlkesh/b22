package collectionsframework.beforegenerics.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorClassTest {
    public static void main(String[] args) {
/*
        var languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("Scala");
        languages.add("Python");
        languages.add("Kotlin");
        languages.add("Go");
        languages.add("Ruby");
*/
        /*for (String language : languages) {
            languages.remove(language);
        }*/

        var languages = new CopyOnWriteArrayList<String>();
        languages.add("Java");
        languages.add("Scala");
        languages.add("Python");
        languages.add("Kotlin");
        languages.add("Go");
        languages.add("Ruby");

        Iterator<String> iterator = languages.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
//            if (next.equals("Java"))
            languages.add(next + "12");
        }
        System.out.println(languages);

    }
}

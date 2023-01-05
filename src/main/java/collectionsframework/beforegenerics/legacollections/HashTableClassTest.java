package collectionsframework.beforegenerics.legacollections;

import java.util.Hashtable;

public class HashTableClassTest {
    public static void main(String[] args) {
        var ht = new Hashtable<String, String>();
        ht.put("Hello", "Salut");
        String hello = ht.get("Hello");

    }
}

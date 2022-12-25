package collectionsframework.beforegenerics.dictionary;

import java.util.Hashtable;

public class Dictionary<K, V> {
    private Object[] elements;
    private static int initialCapacity = 16;


    public Dictionary() {
        this(initialCapacity);
    }

    public Dictionary(int initialCapacity) {
        this.elements = new Object[initialCapacity];
    }

    public boolean put(K key, V value) {
        int index = generateIndex(key);
        elements[index] = value;
        return true;
    }


    @SuppressWarnings("unchecked")
    public V get(K key) {
        int index = generateIndex(key);
        return (V) elements[index];
    }


    private int generateIndex(Object key) {
        return Math.abs(key.hashCode() % initialCapacity);
    }
}

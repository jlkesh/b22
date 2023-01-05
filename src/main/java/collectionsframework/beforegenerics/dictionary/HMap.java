package collectionsframework.beforegenerics.dictionary;

import java.util.Objects;

public class HMap<K, V> {
    public static final int DEFAULT_CAPACITY = 16;
    private final Node<K, V>[] table;

    public HMap() {
        this(DEFAULT_CAPACITY);
    }


    @SuppressWarnings("unchecked")
    public HMap(int initialCapacity) {
        this.table = new Node[initialCapacity];
    }

    public V put(K key, V value) {
        var newNode = new Node<>(hash(key), key, value);
        int index = index(key);
        var node = table[index];
        if (node == null) {
            table[index] = newNode;
            return null;
        } else {
            while (node != null) {
                if (node.hash == hash(key) && Objects.equals(node.key, key)) {
                    V oldValue = node.value;
                    node.value = value;
                    return oldValue;
                }
                node = node.next;
            }
            node.next = newNode;
            return value;
        }
    }

    public V get(K key) {
        var node = table[index(key)];
        if (node == null)
            return null;
        V value = null;
        while (node != null) {
            if (node.hash == hash(key) && Objects.equals(node.key, key)) {
                return node.value;
            }
            value = node.value;
            node = node.next;
        }
        return value;
    }


    private int hash(K key) {
        return (key != null ? key.hashCode() >>> 16 : 0);
    }

    private int index(K key) {
        return hash(key) % DEFAULT_CAPACITY;
    }


    private static class Node<K, V> {
        private int hash;
        private K key;
        private V value;

        Node<K, V> next;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}

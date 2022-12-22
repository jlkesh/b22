package collectionsframework.beforegenerics;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.BiPredicate;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private int size;

    public boolean add(E item) {
        var newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
            size++;
            return true;
        }

        var x = head;
        while (x.next != null)
            x = x.next;

        x.next = newNode;
        size++;
        return true;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        var x = getNode(index);
        return x.item;
    }

    public boolean add(int index, E item) {
        Objects.checkIndex(index, size);
        Node<E> prev = null;
        var x = head;
        var newNode = new Node<>(item);
        int i = 0;
        while (x != null) {
            if (i == index) {
                if (prev == null) {
                    head = newNode;
                } else {
                    prev.next = newNode;
                }
                newNode.next = x;
                size++;
                return true;
            }
            prev = x;
            x = x.next;
            i++;
        }
        return false;
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            E oldValue = head.item;
            head = head.next;
            size--;
            return oldValue;
        } else {
            var prev = getNode(index - 1);
            var x = getNode(index);
            prev.next = x.next;
            size--;
            return x.item;
        }
    }

    public boolean remove(Object o) {
        Objects.checkIndex(0, size);
        return removeObject(((o == null) ?
                (x, obj) -> x.item == null :
                (x, obj) -> x.item.equals(obj)), o);
    }


    private boolean removeObject(BiPredicate<Node<E>, Object> predicate, Object o) {
        Node<E> prev = null;
        var x = head;

        while (x != null) {
            if (predicate.test(x, o)) {
                if (prev == null) {
                    head = x.next;
                } else {
                    prev.next = x.next;
                }
                return true;
            }
            prev = x;
            x = x.next;
        }
        return false;
    }


    private Node<E> getNode(int index) {
        var x = head;
        for (int i = 1; i <= index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        var x = head;
        while (x != null) {
            sj.add(String.valueOf(x.item));
            x = x.next;
        }
        return sj.toString();
    }

    public int size() {
        return size;
    }

    class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
            this.next = null;
        }
    }
}

class SinglyLinkedListTest {
    public static void main(String[] args) {
        var sll = new SinglyLinkedList<String>();
        sll.add("Java");
        sll.add("Scala");
        sll.add("Kotlin");
        sll.add("Python");
        sll.add("C++");
        sll.add(null);
        System.out.println(sll);
        System.out.println(sll.add(5,"ABAP"));
        System.out.println(sll);
    }
}

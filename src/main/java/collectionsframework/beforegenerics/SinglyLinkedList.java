package collectionsframework.beforegenerics;

import java.util.Objects;
import java.util.StringJoiner;

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

    public E remove(Object remove) {
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
        sll.add("C#");
        System.out.println(sll);
        System.out.println(sll.remove(3));
        System.out.println(sll);

        System.out.println(sll.remove(0));
        System.out.println(sll);

        System.out.println(sll.remove(0));
        System.out.println(sll);
    }
}

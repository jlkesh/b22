package collectionsframework.beforegenerics;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class DoublyLinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;


    public boolean add(E element) {
        var newNode = new Node<>(element);
        var t = tail;
        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            t.next = newNode;
            newNode.prev = t;
            tail = newNode;
        }
        size++;
        return true;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> temp;
        int counter = 0;
        if (index < size / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
                counter++;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
                counter++;
            }
        }
        System.out.println(counter);
        return temp.element;
    }

    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        this.forEach(e -> sj.add(String.valueOf(e)));
        return sj.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                var element = current.element;
                current = current.next;
                return element;
            }
        };
    }

    private static class Node<E> {
        Node<E> prev;
        Node<E> next;
        E element;

        public Node(E element) {
            this.element = element;
        }
    }


}
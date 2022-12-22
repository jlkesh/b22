package collectionsframework.beforegenerics;

import java.awt.image.SinglePixelPackedSampleModel;
import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Consumer;

public class SinglyLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private int size;

    public boolean add(E element) {
        var newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            var x = this.head;
            while (x.next != null) {
                x = x.next;
            }
            x.next = newNode;

        }
        size++;
        return true;
    }

    public boolean addAtBeginning(E element) {
        var newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }


    public boolean set(int index, E element) {
        Objects.checkIndex(index, this.size); // show inside the method
        if (index == 0) {
            addAtBeginning(element);
            return true;
        }

        var temp = this.head;
        for (int i = 1; i < index; i++)
            temp = temp.next;

        var newNode = new Node<>(element);
        newNode.next = temp.next;
        temp.next = newNode;
        this.size++;
        return true;
    }

    public boolean removeFromBegin() {
        if (this.head == null) return false;
        this.head = this.head.next;
        return true;
    }

    public boolean remove(int index) {
        Objects.checkIndex(index, this.size);
        if (index == 0) {
            removeFromBegin();
            return true;
        }

        var temp = this.head;
        for (int i = 1; i < index; i++)
            temp = temp.next;
        temp.next = temp.next.next;
        this.size--;
        return true;
    }

    public boolean remove(Object o) {

        if (this.head == null)
            throw new IllegalArgumentException("LinkedList is empty");

        Node<E> prev = null;
        Node<E> current = head;

        while (current != null) {
            if (Objects.equals(current.element, o)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }


    public E get(int index) {
        Objects.checkIndex(index, this.size);
        var x = node(index);
        return x.element;
    }


    private Node<E> node(int index) {
        if (index == 0)
            return head;

        var x = head;
        for (int i = 1; i <= index; i++)
            x = x.next;

        return x;
    }

    public int size() {
        return size;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
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
                E value = current.element;
                current = current.next;
                return value;
            }
        };
    }


    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        for (E e : this) sj.add(String.valueOf(e));
        return sj.toString();
    }


    static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

    }

    public static void main(String[] args) {

        var sll = new SinglyLinkedList<String>();

        sll.add("Java");
        sll.add("Python");
        sll.add("Scala");
        sll.add(null);
        sll.add("Kotlin");
        sll.add("Groovy");
        for (String s : sll) {
            System.out.println(s);
        }
        System.out.println("sll = " + sll);
    }
}


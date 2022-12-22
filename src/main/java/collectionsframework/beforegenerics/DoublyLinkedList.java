package collectionsframework.beforegenerics;

import java.util.Objects;
import java.util.StringJoiner;

public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public boolean add(E element) {
        var newNode = new Node<>(element);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
        return true;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        var x = getNode(index);
        return x.element;
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        var x = getNode(index);
        if (x.prev == null) {
            head = head.next;
        } else {
            if (x.next == null) {
                tail = tail.prev;
                tail.next = null;
            } else {
                var tempPrev = x.prev;
                var tempNext = x.next;
                tempPrev.next = tempNext;
                tempNext.prev = tempPrev;
            }
        }
        size--;
        return x.element;
    }


    private Node<E> getNode(int index) {
        Node<E> temp = (size / 2 < index) ? tail : head;
        for (int i = 0; i < ; i++) {

        }

        return x;
    }


    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        var x = head;
        while (x != null) {
            sj.add(String.valueOf(x.element));
            x = x.next;
        }
        return sj.toString();
    }

    class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}

class DoublyLinkedListTest {
    public static void main(String[] args) {
        var dll = new DoublyLinkedList<String>();
        dll.add("Java");
        dll.add("Scala");
        dll.add("C++");
        dll.add("Kotlin");
        System.out.println(dll);
        System.out.println(dll.remove(0));
        System.out.println(dll);
    }
}

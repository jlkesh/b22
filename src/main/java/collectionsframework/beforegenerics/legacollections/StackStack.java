package collectionsframework.beforegenerics.legacollections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class StackStack<E> implements Iterable<E> {

    public static final int DEFAULT_CAPACITY = 20;
    private Object[] elements;
    private int size;

    public StackStack() {
        this(DEFAULT_CAPACITY);
    }

    public StackStack(int capacity) {
        this.elements = new Object[capacity];
    }


    public boolean push(E element) {
        if (isFull())
            throw new RuntimeException("Stack is full");
        elements[size++] = element;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        E oldValue = (E) elements[--size];
        elements[size] = null;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return (E) elements[size - 1];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        this.forEach(el -> sj.add(Objects.toString(el)));
        return sj.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new StackStackIterator();
    }

    private class StackStackIterator implements Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            return (E) elements[current++];
        }
    }
}

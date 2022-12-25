package collectionsframework.beforegenerics.queue;

import java.util.Arrays;

public class SimpleQueue<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public SimpleQueue() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleQueue(int capacity) {
        this.elements = new Object[capacity];
    }

    public boolean enqueue(E element) {
        if (isFull()) throw new RuntimeException("Queue is full");
        elements[size++] = element;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        E element = (E) elements[0];
        System.arraycopy(elements, 1, elements, 0, --size);
        elements[size] = null;
        return element;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return (E) elements[0];
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}

package collectionsframework.beforegenerics;

import java.util.Iterator;
import java.util.function.Consumer;

public class Counter implements Iterable<Integer> {
    private int min;
    private int step;
    private int max;
    private int currentValue;

    public Counter(int max) {
        this(0, 1, max);
    }

    public Counter(int step, int max) {
        this(0, step, max);
    }

    public Counter(int min, int step, int max) {
        this.min = min;
        this.step = step;
        this.max = max;
        this.currentValue = min;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new CounterIterator();
    }

    private class CounterIterator implements Iterator<Integer> {
        @Override
        public boolean hasNext() {
            return currentValue < max;
        }

        @Override
        public Integer next() {
            int oldValue = currentValue;
            currentValue = currentValue + step;
            return oldValue;
        }
    }
}

package generics;


import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

/**
 * @param <E> type parameter
 */
class GenericClass<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size = 0;

    public GenericClass() {
        this(DEFAULT_CAPACITY);
    }

    public GenericClass(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    public boolean add(E item) {
        if (size == elementData.length)
            grow();
        this.elementData[size++] = item;
        return true;
    }

    private void grow() {
        Object[] o = elementData;
        int newCapacity = o.length + o.length / 2 + 1;
        this.elementData = Arrays.copyOf(o, newCapacity);
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }


    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size));
    }
}


public class Main {
    public static void main(String[] args) {
        GenericClass<String> genericClass = new GenericClass<String>(2);// type argument
        genericClass.add("Java");
        genericClass.add("Groovy");
        genericClass.add("Scala");
        genericClass.add("Kotlin");
        genericClass.add("Go");
        genericClass.add("Cpp");
        genericClass.add("C");
        genericClass.add("C#");
        System.out.println(genericClass);

/*        GenericClass<Integer> integerGenericClass = new GenericClass<>(3);
        integerGenericClass.add(123);
        integerGenericClass.add(12);
        integerGenericClass.add(3);
        Integer o = (Integer) integerGenericClass.get(0);
        System.out.println(integerGenericClass);*/
    }
}
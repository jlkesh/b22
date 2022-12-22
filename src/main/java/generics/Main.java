package generics;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @param <E> type parameter
 */
class ArrayList<E> implements Iterable<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size = 0;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    public boolean add(E item) {
        if (size == elementData.length)
            grow();
        this.elementData[size++] = item;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elementData[index];
    }


    public E remove(int index) {
        E oldItem = get(index);
        int newSize;
        if ((newSize = size - 1) > index) {
            System.arraycopy(this.elementData, index + 1, this.elementData, index, newSize - index);
        }
        this.elementData[size = newSize] = null;
        return oldItem;
    }

    public boolean remove(Object o) {
        int index = 0;
        found:
        {
            if (o == null) {
                for (; index < size; index++) {
                    if (elementData[index] == null) {
                        break found;
                    }
                }
            } else {
                for (; index < size; index++) {
                    if (o.equals(elementData[index])) {
                        break found;
                    }
                }
            }
            return false;
        }
        remove(index);
        return true;
    }

    private void grow() {
        Object[] o = elementData;
        int newCapacity = o.length + o.length / 2 + 1;
        this.elementData = Arrays.copyOf(o, newCapacity);
    }


    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size));
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) Arrays.stream(elementData)
                .limit(size)
                .iterator();
    }
}


public class Main {
    public static void main(String[] args) {
        var genericClass = new ArrayList<String>();// type argument
        genericClass.add("Java");
        genericClass.add("Groovy");
        genericClass.add("Scala");
        genericClass.add("Kotlin");
        genericClass.add("Go");
        genericClass.add("Cpp");
        genericClass.add(null);
        genericClass.add("C#");
        for (String aClass : genericClass) {
            System.out.println(aClass);
        }

        System.out.println(genericClass);
        String oldItem = genericClass.remove(0);
        genericClass.remove(null);
        System.out.println(genericClass);
        genericClass.remove("Groovy");
        System.out.println(genericClass);
        genericClass.remove("C#");
        System.out.println(genericClass);

        for (String s : genericClass) {
            System.out.println("s = " + s);
        }
        var integerGenericClass = new ArrayList<Integer>(3);
        integerGenericClass.add(123);
        integerGenericClass.add(12);
        integerGenericClass.add(3);
        Integer o = (Integer) integerGenericClass.get(0);
        System.out.println(integerGenericClass);
    }
}

class MathUtils {
    static <T extends Comparable<T>> int compare(T obj1, T obj2) {
        return obj1.compareTo(obj2);
    }

/*    static <AER extends Comparable<AER>> int compare(AER obj1, AER obj2) {
        return obj1.compareTo(obj2);
    }*/
    /*
    static  int compare(Object obj1, Object obj2) {
        return obj1.compareTo(obj2);
    }

    static  int compare(Comparable obj1, Comparable obj2) {
        return obj1.compareTo(obj2);
    }
    */

    record Employee(String id, int age) implements Comparable<Employee> {
        @Override
        public int compareTo(Employee o) {
            return Integer.compare(this.age, o.age);
        }
    }

    public static void main(String[] args) {
        System.out.println(MathUtils.compare("Hello", "he"));
        var emp1 = new Employee("1", 34);
        var emp2 = new Employee("2", 18);
        System.out.println(MathUtils.compare(emp1, emp2));
    }
}
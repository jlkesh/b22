package collectionsframework.beforegenerics;

public class CounterTest {
    public static void main(String[] args) {
        var counter = new Counter(20,10,100);
        counter.forEach(System.out::println);
    }
}

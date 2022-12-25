package collectionsframework.beforegenerics.queue;

public class SQTest {
    public static void main(String[] args) {
        var sq = new SimpleQueue<String>();
        System.out.println(sq);
        sq.enqueue("Java");
        System.out.println(sq.peek());
        System.out.println(sq);
        System.out.println(sq.dequeue());
//        System.out.println(sq.enqueue("Scala"));
        System.out.println(sq);
    }
}

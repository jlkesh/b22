package collectionsframework.beforegenerics;

public class DLLTest {
    public static void main(String[] args) {
        var dll = new DoublyLinkedList<String>();
        dll.add("Java");
        dll.add("Python");
        dll.add("Groovy");
        dll.add("Scala");
        dll.add("GO");
        // dll.forEach(System.out::println);
        System.out.println(dll.get(0));
    }
}

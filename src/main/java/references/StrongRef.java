package references;

public class StrongRef {
    public static void main(String[] args) {
        String name = "name";
        System.out.println("name = " + name);
        name = null;
    }
}

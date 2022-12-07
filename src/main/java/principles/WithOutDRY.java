package principles;

public class WithOutDRY {
    public int sum(int a, int b) {
        int sum = a + b;
        System.out.printf("sum = %d%n", sum);
        return sum;
    }

    public int average(int a, int b) {
        int sum = a + b;
        System.out.printf("sum = %d%n", sum);
        return sum / 2;
    }

    public static void main(String[] args) {
        WithOutDRY dry = new WithOutDRY();
        System.out.println(dry.sum(12, 2));
        System.out.println(dry.average(12, 2));
    }
}


class WithDRY {
    public int sum(int a, int b) {
        int sum = a + b;
        System.out.printf("sum = %d%n", sum);
        return sum;
    }

    public int average(int a, int b) {
        return sum(a, b) / 2;
    }

    public static void main(String[] args) {
        WithDRY dry = new WithDRY();
        System.out.println(dry.sum(12, 2));
        System.out.println(dry.average(12, 2));
    }
}

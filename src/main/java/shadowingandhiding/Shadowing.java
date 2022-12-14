package shadowingandhiding;

public class Shadowing {
    private int age = 90;

    int r() {
        String age = "9";
        return Integer.valueOf(age);
    }

    public static void main(String[] args) {
        System.out.println(new Shadowing().r());
    }
}

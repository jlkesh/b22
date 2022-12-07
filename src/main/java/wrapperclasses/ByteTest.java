package wrapperclasses;

public class ByteTest {
    public static void main(String[] args) {

        int integer = Integer.valueOf("123");
        int i = Integer.parseInt("123");

        System.out.println(isDigit("123"));
        System.out.println(isDigit("123A"));
        System.out.println(Character.digit('A', 16));
        System.out.println(Character.digit('B', 10));
        System.out.println(Character.digit('3', 2));
    }

    static boolean isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) //c < '0' || c > '9'
                return false;
        }
        return true;
    }
}


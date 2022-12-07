package string;

public class StringTest {
    public static void main(String[] args) {
        String ss = new String("213");
        String a = "";

        StringBuffer stringBuffer = new StringBuffer("Hello");
        for (int i = 0; i < 1e2; i++) {
            stringBuffer.append(i);
            System.out.println(stringBuffer.capacity()); // 16 + 16 + 2 = 34 || 34 + 34 + 2 || 70
        }

        StringBuilder stringBuilder = new StringBuilder("Hello");
        for (int i = 0; i < 1e2; i++) {
            stringBuilder.append(i);
            System.out.println(stringBuilder.capacity()); // 16 + 16 + 2 = 34 || 34 + 34 + 2 || 70
        }



    }
}

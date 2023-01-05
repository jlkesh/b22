package references;

import java.lang.ref.SoftReference;

public class SoftReferenceExp {
    public static void main(String[] args) {
        String name = "Javohir";
        SoftReference<String> softReference = new SoftReference<>(name);
        name = null;
        String s = softReference.get();
        System.out.println(s);
    }
}

package references;

import java.lang.ref.WeakReference;

public class WeakReferenceExp {
    public static void main(String[] args) {
        String name = "Javohir";
        WeakReference<String> weakReference = new WeakReference<>(name);
        name = null;
        System.gc();
        System.out.println(weakReference.get());
    }
}

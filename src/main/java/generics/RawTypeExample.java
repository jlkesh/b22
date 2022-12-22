package generics;

public class RawTypeExample<E> {
    private E item;

    public void setItem(E item) {
        this.item = item;
    }

    @SuppressWarnings({"rawtypes","unchecked"})
    public static void main(String[] args) {

        RawTypeExample rawTypeExample = new RawTypeExample();
        rawTypeExample.setItem("234");
    }
}

package initializerblocks;

public class StaticBlock {
    static {
        System.out.println("Static Block 4");
    }static {
        System.out.println("Static Block 5");
    }

    static {
        System.out.println("Static Block 2");
    }

    public StaticBlock() {
        System.out.println("E C");
    }

    public static void main(String[] args) {
        System.out.println("Main method");
        new StaticBlock();
        new StaticBlock();
        new StaticBlock();
    }
}

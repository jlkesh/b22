package initializerblocks;

public class InstanceBlock {

    {
        System.out.println("Hi I'm instance block )) 2");
    }

    {
        System.out.println("Hi I'm instance block )) 1");
    }

    {
        System.out.println("Hi I'm instance block )) 3");
    }

    public InstanceBlock() {
        System.out.println("Empty Constructor");
    }

    public InstanceBlock(int a) {
        System.out.println("PR Constructor");
    }


    public static void main(String[] args) {
        System.out.println("Main method");
        new InstanceBlock();
        new InstanceBlock();
        new InstanceBlock();
        new InstanceBlock(2);
    }
}

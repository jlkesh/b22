package collectionsframework.beforegenerics.legacollections;

import java.util.Stack;

public class StackClassTest {
    public static void main(String[] args) {
        var stack = new Stack<String>();
        stack.push("Java");
        stack.push("Scala");
        stack.push("Python");
        stack.push("Groovy");
        // stack.push(null);
        stack.push("Kotlin");
        System.out.println(stack);
        for (String s : stack) {

        }

    }
}

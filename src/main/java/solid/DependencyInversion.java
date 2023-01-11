package solid;

import java.security.Key;

public class DependencyInversion {
    public static void main(String[] args) {
        var simpleKeyboard = new SimpleKeyboard();
        var magicKeyboard = new MagicKeyboard();
        var computer1 = new Computer("Code i9", "Intel", simpleKeyboard);
        var computer2 = new Computer("Code i9", "Intel", magicKeyboard);
    }
}


class Computer {
    private String cpu;
    private String maker;
    private Keyboard keyboard;

    public Computer(String cpu, String maker, Keyboard keyboard) {
        this.cpu = cpu;
        this.maker = maker;
        this.keyboard = keyboard;
    }
}

interface Keyboard{}
class SimpleKeyboard implements Keyboard {}
class MagicKeyboard implements Keyboard {}

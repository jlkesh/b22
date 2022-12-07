package coupling;

public class Computer {
    private int coreCount;
    private Keyboard keyBoard;

    public Computer(int coreCount, Keyboard keyBoard) {
        this.coreCount = coreCount;
        this.keyBoard = keyBoard;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    public Keyboard getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(Keyboard keyBoard) {
        this.keyBoard = keyBoard;
    }

    public static void main(String[] args) {
        SimpleKeyBoard keyBoard = new SimpleKeyBoard();
        Computer computer = new Computer(24, keyBoard);
        RedDragonKeyboard redDragonKeyboard = new RedDragonKeyboard();
        computer.setKeyBoard(redDragonKeyboard);
    }
}

interface Keyboard {

}

class SimpleKeyBoard implements Keyboard {

}

class RedDragonKeyboard implements Keyboard {

}
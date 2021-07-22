package hw_20072021;

public class MyArrayDataException extends NumberFormatException {
    private final int line;
    private final int column;

    public MyArrayDataException(String s, int line, int column) {
        super(s);
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}
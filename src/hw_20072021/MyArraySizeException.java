package hw_20072021;

public class MyArraySizeException extends IllegalArgumentException {
    private final boolean line;
    private final boolean column;

    public MyArraySizeException(String s, boolean line, boolean column) {
        super(s);
        this.line = line;
        this.column = column;
    }

    public boolean isLine() {
        return line;
    }

    public boolean isColumn() {
        return column;
    }
}
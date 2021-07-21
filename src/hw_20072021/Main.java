package hw_20072021;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"11", "93", "87", "61"},
                {"111", "931", "871", "611"},
                {"112", "932", "872", "612"},
                {"113", "933", "873", "613"},
        };

        try {
            System.out.println(method(arr));
        } catch (MyArraySizeException e) {
            if (e.isLine()) {
                System.out.println("Number of lines is not correct");
            }
            if (e.isColumn()) {
                System.out.println("Number of columns is not correct");
            }
        } catch (MyArrayDataException e) {
            System.out.printf("Line: %d. Column: %d.", e.getLine(), e.getColumn());
        }
    }

    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr.length != 4) {
                    throw new MyArraySizeException("Not valid size of array", true, false);
                }
                if (arr[i].length != 4) {
                    throw new MyArraySizeException("Not valid size of array", false, true);
                }
                try {
                    int index = Integer.parseInt(arr[i][j]);
                    sum += index;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Not valid index: [" + i + "]" + "[" + j + "]", i, j);
                }
            }
        }
        return sum;
    }
}
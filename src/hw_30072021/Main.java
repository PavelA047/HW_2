package hw_30072021;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;

    public static void main(String[] args) {
        float[] arr = firstMethod();
        secondMethod(arr);
    }

    public static float[] firstMethod() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) *
                    Math.cos(0.4f + (float) i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
        return arr;
    }

    public static void secondMethod(float[] arr) {
        long a = System.currentTimeMillis();
        float[] arr1 = new float[SIZE / 2];
        float[] arr2 = new float[SIZE / 2];
        System.arraycopy(arr, 0, arr1, 0, (SIZE) / 2);
        System.arraycopy(arr, SIZE / 2, arr2, 0, SIZE / 2);
        System.out.println(System.currentTimeMillis() - a);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) *
                        Math.cos(0.4f + (float) i / 2));
            }
            System.out.println(System.currentTimeMillis() - a);
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (float) (i + SIZE / 2) / 5) * Math.cos(0.2f +
                        (float) (i + SIZE / 2) / 5) * Math.cos(0.4f + (float) (i + SIZE / 2) / 2));
            }
            System.out.println(System.currentTimeMillis() - a);
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long b = System.currentTimeMillis();
        float[] arrNew = new float[SIZE];
        System.arraycopy(arr1, 0, arrNew, 0, SIZE / 2);
        System.arraycopy(arr2, 0, arrNew, SIZE / 2, SIZE / 2);
        System.out.println(System.currentTimeMillis() - b);
    }
}

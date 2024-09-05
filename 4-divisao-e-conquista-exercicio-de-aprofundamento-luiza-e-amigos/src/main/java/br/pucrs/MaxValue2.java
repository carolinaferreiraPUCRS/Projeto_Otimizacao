package br.pucrs;

public class MaxValue2 {
    public static long maxVal2(long[] A, int init, int end) {
        if (end - init <= 1)
            return Math.max(A[init], A[end]);

        int m = (init + end) / 2;
        long v1 = maxVal2(A, init, m);
        long v2 = maxVal2(A, m + 1, end);

        return Math.max(v1, v2);
    }

    public static void main(String[] args) {
        int[] sizes = {32, 2048, 1048576};

        for (int size : sizes) {
            long[] array = generateRandomArray(size);

            long startTime = System.nanoTime();
            long maxValue = maxVal2(array, 0, array.length - 1);
            long endTime = System.nanoTime();

            System.out.println("Array size: " + size);
            System.out.println("Max value: " + maxValue);
            System.out.println("Time taken (ns): " + (endTime - startTime));
            System.out.println();
        }
    }

    private static long[] generateRandomArray(int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = (long) (Math.random() * 100000);
        }
        return array;
    }
}


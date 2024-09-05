package br.pucrs;

public class MaxValue1 {
    public static long maxVal1(long[] A, int n) {
        long max = A[0];
        int iterationCount = 0;

        for (int i = 1; i < n; i++) {
            iterationCount++; // Contabilizando iterações
            if (A[i] > max)
                max = A[i];
        }
    
        System.out.println("Iterations: " + iterationCount);
        return max;
    }

    public static void main(String[] args) {
        int[] sizes = {32, 2048, 1048576};

        for (int size : sizes) {
            long[] array = generateRandomArray(size);

            long startTime = System.nanoTime();
            long maxValue = maxVal1(array, array.length);
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


package br.pucrs;

public class MergeSort {
    private static int iterationCount = 0;

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[middle + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            iterationCount++; // Contabilizando iterações
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] sizes = {32, 2048, 1048576};

        for (int size : sizes) {
            int[] array = generateRandomArray(size);
            iterationCount = 0;

            long startTime = System.nanoTime();
            mergeSort(array, 0, array.length - 1);
            long endTime = System.nanoTime();

            System.out.println("Array size: " + size);
            System.out.println("Iterations: " + iterationCount);
            System.out.println("Time taken (ns): " + (endTime - startTime));
            System.out.println();
        }
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        return array;
    }
}
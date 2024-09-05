package br.pucrs;

public class IntegerMultiplication {
    public static long multiply(long x, long y, int n) {
        if (n == 1)
            return x * y;

        int m = (n + 1) / 2;
        long a = x >> m;
        long b = x & ((1L << m) - 1);
        long c = y >> m;
        long d = y & ((1L << m) - 1);

        long e = multiply(a, c, m);
        long f = multiply(b, d, m);
        long g = multiply(b, c, m);
        long h = multiply(a, d, m);

        return (e << (2 * m)) + ((g + h) << m) + f;
    }

    public static void main(String[] args) {
        int[] bitSizes = {4, 16, 64};
        long x = 0xFFFFFFFFFFFFFFFFL;
        long y = 0xFFFFFFFFFFFFFFFFL;

        for (int n : bitSizes) {
            long startTime = System.nanoTime();
            long result = multiply(x, y, n);
            long endTime = System.nanoTime();

            System.out.println("Bits: " + n);
            System.out.println("Result: " + result);
            System.out.println("Time taken (ns): " + (endTime - startTime));
            System.out.println();
        }
    }
}


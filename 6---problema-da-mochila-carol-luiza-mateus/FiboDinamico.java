/**
 * 1. Dadas as três versões de implementação de Fibonacci abaixo:
 *
 *     * implemente os algortimos;
 *     * teste todos para os inteiros 4, 8, 16, 32;
 *     * teste os dois últimos também para os inteiro 128, 1000 e 10.000. -> da overflow!! estoura o tamanho

  */
public class FiboDinamico {
    public static void main(String[] args) {
        int x = FiboRec(4);
        System.out.println("FiboRec: " + x);

        int y = Fibo(128);
        System.out.println("Fibo: " + y);

        int z = MemoizedFibo(new int[129], 128); //inicializar o vetor com o valor de n+1
        System.out.println("MemoizedFibo: " + z);
    }

    public static int FiboRec(int n) {
        if (n <= 1) {
            return n;
        } else {
            int a = FiboRec(n - 1);
            int b = FiboRec(n-2);
            return a + b;
        }
    }

    public static int Fibo(int n) {
        int[] f = new int[n + 1];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <=n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static int MemoizedFibo(int[] f, int n) {
        for (int i = 0; i<=n; i++) {
            f[i] = -1;
        }
        return LookupFibo(f, n);
    }

    public static int LookupFibo(int[] f, int n) {
        if (f[n] >= 0) {
            return f[n];
        }
        if (n <= 1) {
            return f[n] = n;
        } else {
            f[n] = LookupFibo(f, n-1) + LookupFibo(f, n-2);
        }
        return f[n];
    }
}

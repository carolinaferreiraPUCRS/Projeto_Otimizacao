/**
 * Ache uma solução que testa todas as combinações possíveis e seleciona a melhor, aplicando divisão-e-conquista ou não;
 * Contabilize o número de iterações;
 * Implemente e teste sua solução, para o caso exposto em aula e outros de mesmo porte (;-)).
 *
 * N = número de produtos;
 * C = capacidade real da mochila
 * itens[N +1]; (O índice 0 guarda null)
 * maxTab[N+1][C+1];
 *
 * Inicialize com 0 toda a linha 0 e também a coluna 0;
 * para i = 1 até N
 *   para j = 1 até C
 *      se item itens[i].peso <= j // se o item cabe na mochila atual
 *          maxTab[i][j] = Max(maxTab[i-1][j],
 *                  itens[i].valor +
 *                       maxTab[i-1][j – itens[i].peso]);
 *      senão
 *          maxTab[i][j] = maxTab[i-1][j];
 * retorne maxTab[N][C] // valor máximo para uma mochila de capacidade C e //que pode conter itens que vão do item 1 até o item N.
 *
*/
public class Mochila {
    public static void main(String[] args) {
        int[] pesos = {5, 2, 2, 1};
        int[] valores = {2, 4, 2, 3};
        int capacidade = 7;

        int maxValue = Knapsack(pesos, valores, capacidade);
        System.out.println(maxValue);
    }

    public static int Knapsack(int[] pesos, int[] valores, int capacidade) {
        int n = pesos.length;
        int [][] maxTab = new int[n+1][capacidade+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacidade; j++) {
                if (pesos[i - 1] > j) { //se o peso do item i-1 for maior que a capacidade, não podemos incluí-lo
                    maxTab[i][j] = maxTab[i-1][j]; //o valor é o mesmo se não considerássemos esse item
                } else {
                    //podemos escolher incluir ou não o item, o que for melhor
                    maxTab[i][j] = Math.max(maxTab[i-1][j], maxTab[i-1][j-pesos[i - 1]] + valores[i - 1]);
                }
            }
        }

        //o valor máximo estará em maxTab[n][capacidade]
        return maxTab[n][capacidade];
    }
}
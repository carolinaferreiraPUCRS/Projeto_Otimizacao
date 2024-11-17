/*
* Problema da Soma dos Subconjuntos

O problema da soma dos subconjuntos é um problema de ciência da computação que
consiste em verificar se, dado um conjunto de inteiros, existe um subconjunto não-vazio cuja soma é zero.

Por exemplo, no conjunto {−7, −3, −2, 5, 8}, a resposta é sim, pois o subconjunto {−3, −2, 5} resulta em uma soma de zero.

Faça um método que recebe um conjunto de inteiros e retorna um subconjunto cuja soma seja zero;
Altere o método para que retorne todos subconjuntos cuja soma seja zero;
Analise a complexidade de ambas as soluções.
*/

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] c = {-7, -3, -2, 5, 8};
        List<Integer> resultado = encontrarSubconjuntoComSomaZero(c);
        if (resultado != null) {
            System.out.println("Subconjunto encontrado: " + resultado);
        } else {
            System.out.println("Nenhum subconjunto com soma zero encontrado.");
        }
    }

    public static List<Integer> encontrarSubconjuntoComSomaZero(int[] c) {
        List<Integer> subconjunto = new ArrayList<>();
        if (retornaUmSubconjunto(c,0, subconjunto)) {
            return subconjunto;
        }
        return null;
    }

    public static boolean retornaUmSubconjunto(int[] c, int index, List<Integer> subConjunto) {
        int i = c[index];
        int j = c[index+1];
        int sum = i+j;

        for (int k = index+2; k < c.length; k++) {
            if (sum + c[k] == 0) {
                subConjunto.add(i);
                subConjunto.add(j);
                subConjunto.add(c[k]);
                return true;
            }
        }

        if (subConjunto.isEmpty()) {
            retornaUmSubconjunto(c, index+1, subConjunto);
        }

        if (!subConjunto.isEmpty()) {
            return true;
        }

        return false;
    }

}
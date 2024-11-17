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
        if (retornaUmSubconjunto(c,0, subconjunto, 0)) {
            return subconjunto;
        }
        return null;
    }

    public static boolean retornaUmSubconjunto(int[] c, int index, List<Integer> subConjunto, int somaAtual) {
        if (somaAtual == 0 && !subConjunto.isEmpty()) {
            return true;
        }

        if (index == c.length) {
            return false; //chegou ao fim do conjunto sem encontrar
        }

        //Adiciona o elemento atual no subconjunto
        subConjunto.add(c[index]);
        if (retornaUmSubconjunto(c, index + 1, subConjunto, somaAtual + c[index])) {
            return true;
        }

        //Excluir o elemento atual do subconjunto
        subConjunto.remove(subConjunto.size() - 1);
        if (retornaUmSubconjunto(c, index + 1, subConjunto, somaAtual + c[index])) {
            return true;
        }

        return false;
    }
}
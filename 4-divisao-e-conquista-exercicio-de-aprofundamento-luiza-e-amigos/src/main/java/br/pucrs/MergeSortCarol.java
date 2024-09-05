package br.pucrs;
public class MergeSortCarol {
  public static void mergeSort(int[] array) {
    if (array.length < 2) {
      return;
    }

    int meio = array.length / 2;
    int[] esquerda = new int[meio];
    int[] direita = new int[array.length - meio];

    for (int i = 0; i < meio; i++) {
      esquerda[i] = array[i];
    }
    for (int i = meio; i < array.length; i++) {
      direita[i - meio] = array[i];
    }

    mergeSort(esquerda);
    mergeSort(direita);

    merge(array, esquerda, direita);
  } 

  public static void merge(int[] array, int[] esquerda, int[] direita) {
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < esquerda.length && j < direita.length) {
      if (esquerda[i] <= direita[j]) {
        array[k] = esquerda[i];
        i++;
      } else {
        array[k] = direita[j];
        j++;
      }
      k++;
    }

    while (i < esquerda.length) {
      array[k] = esquerda[i];
      i++;
      k++;
    }

    while (j < direita.length) {
      array[k] = direita[j];
      j++;
      k++;
    }
  }
}

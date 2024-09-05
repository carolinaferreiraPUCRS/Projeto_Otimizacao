package br.pucrs;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int array[] = { 12, 11, 13, 5, 6, 7 };
        MergeSortCarol.mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

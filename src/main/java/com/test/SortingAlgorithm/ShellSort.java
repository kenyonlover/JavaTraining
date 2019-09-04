package com.test.SortingAlgorithm;

/**
 * 希尔排序
 */
public class ShellSort {
    public void shellSort(int[] array, int n) {
        int i, j, gap;
        int temp;
        for (gap = n / 2; gap > 0; gap /= 2) {
            for (i = gap; i < n; i++) {       
                for (j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap) {
                    temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;
                }                // 打印每趟排序结果
                for (int m = 0; m <= array.length - 1; m++) {
                    System.out.print(array[m] + "\t");
                }
                System.out.println();
            }
        }
    } 
     public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] array = { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
        shellSort.shellSort(array, array.length);        
        for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
    }
}
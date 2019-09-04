package com.test.SortingAlgorithm;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int a[] = { 2, 3, 6, 4, 0, 1, 7, 8, 5, 9 };
        bubbleSort(a);
    }

    public static void toString(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void bubbleSort(int[] a) {
        int length = a.length;
        int temp = 0;
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = 0; i < a.length - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    // change
                    temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;
                }
            }
        }
        toString(a);
    }
}
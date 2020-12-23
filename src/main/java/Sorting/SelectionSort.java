package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] array = {64, 25, 12, 22, 11};
        sort.sSort(array);
        sort.sSortRecursive(array, array.length, 0);
        System.out.println(Arrays.toString(array));
    }

    public void sSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minimum_element = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minimum_element]) {
                    minimum_element = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minimum_element];
            array[minimum_element] = tmp;
        }
    }

    public void sSortRecursive(int[] array, int n, int index) {
        if (n == index) return;
        int minimum = index;
        for (int i = index; i < n; i++) {
            if (array[minimum] > array[i]) {
                minimum = i;
            }
        }
        int tmp = array[minimum];
        array[minimum] = array[index];
        array[index] = tmp;
        sSortRecursive(array, n, index + 1);
    }

}

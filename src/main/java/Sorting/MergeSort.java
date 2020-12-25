package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] array = {5, 1, 6, 2, 3, 4};
        sort.mergeSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    public void mergeSort(int[] array, int n) {
        if (n < 2) {
            return;
        }
        int m = n / 2;
        int[] l = new int[m];
        int[] r = new int[n - m];
        for (int i = 0; i < m; i++) {
            l[i] = array[i];
        }
        for (int i = m; i < n; i++) {
            r[i - m] = array[i];
        }
        mergeSort(l, m);
        mergeSort(r, n - m);
        merge(array, l, r, m, n - m);
    }

    private void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k++] = l[i++];
            } else {
                array[k++] = r[j++];
            }
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
    }
}

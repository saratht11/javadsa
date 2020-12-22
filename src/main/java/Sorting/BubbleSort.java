package Sorting;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/bubble-sort/
 * https://www.geeksforgeeks.org/recursive-bubble-sort/
 */
public class BubbleSort {
    /**
     * O(n*n)
     */
    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 1};
        sort.bubbleSort01(arr);
        sort.bubbleSort02(arr);
        sort.bubbleSortRec(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public void bubbleSort01(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public void bubbleSort02(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public void bubbleSortRec(int[] array, int n) {
        if (n == 1) return;

        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                int tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
            }
        }
        bubbleSortRec(array, n - 1);
    }

}

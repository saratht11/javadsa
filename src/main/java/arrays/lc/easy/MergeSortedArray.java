package arrays.lc.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray sortedArray = new MergeSortedArray();
        int[] firstArray = {3, 7};
        int[] secondArray = {4, 8, 11};
        System.out.println(Arrays.toString(sortedArray.mergeSortedArray(firstArray, secondArray)));
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        sortedArray.merge01(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        sortedArray.merge02(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * We traverse both the arrays and choose the smaller element and
     * added it to the new element and incremented the array position
     * from which the smallest element is chosen.
     * In the end, we copy the rest of the elements from the firstArray or the Second array.
     * https://www.baeldung.com/java-merge-sorted-arrays
     * TC:O(m+n)
     * SC:O(m+n)
     * where m is length of firstArray && n is length of secondArray
     */
    public int[] mergeSortedArray(int[] firstArray, int[] secondArray) {
        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;
        int[] mergedArray = new int[firstArrayLength + secondArrayLength];
        int firstArrayPosition, secondArrayPosition, middleArrayPosition;
        firstArrayPosition = secondArrayPosition = middleArrayPosition = 0;
        while (firstArrayPosition < firstArrayLength && secondArrayPosition < secondArrayLength) {
            if (firstArray[firstArrayPosition] < secondArray[secondArrayPosition]) {
                mergedArray[middleArrayPosition++] = firstArray[firstArrayPosition++];
            } else {
                mergedArray[middleArrayPosition++] = secondArray[secondArrayPosition++];
            }
        }

        while (firstArrayPosition < firstArrayLength) {
            mergedArray[middleArrayPosition++] = firstArray[firstArrayLength++];
        }

        while (secondArrayPosition < secondArrayLength) {
            mergedArray[middleArrayPosition++] = secondArray[secondArrayPosition++];
        }
        return mergedArray;
    }
    /*
     * These 2 solution are actual leet code problem related solution where same first array is used without using third array
     */

    /**
     * https://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
     */
    public void merge01(int[] firstArray, int m, int[] secondArray, int n) {
        while (m > 0 && n > 0) {
            if (firstArray[m - 1] > secondArray[n - 1]) {
                firstArray[m + n - 1] = firstArray[m - 1];
                m--;
            } else {
                firstArray[m + n - 1] = secondArray[n - 1];
                n--;
            }
        }
        while (n > 0) {
            firstArray[m + n - 1] = secondArray[n - 1];
            n--;
        }
    }

    public void merge02(int[] firstArray, int m, int[] secondArray, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (k >= 0) {
            if (j < 0 || (i >= 0 && firstArray[i] > secondArray[j])) {
                firstArray[k--] = firstArray[i--];
            } else {
                firstArray[k--] = secondArray[j--];
            }
        }
    }
}

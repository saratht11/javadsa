package arrays.lc.easy;

import java.util.Arrays;

/**
 * Remove the specified element from the given array and return the new length
 * (no need to maintain the order of the array)
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        String[] array = {"S", "A", "R", "A", "T", "H"};
        //System.out.println(removeElement.removeElementFromArray(array, "A"));
        //System.out.println(Arrays.toString(array));
        System.out.println(removeElement.removeElementFromArray02(array, "A"));
        System.out.println(Arrays.toString(array));
    }

    /**
     * Approach 01
     * if array element and target element same skip to next element without changing i
     * if array element and target element are not same replace the i th value with jth value and increment i
     */
    public int removeElementFromArray(String[] array, String targetElement) {
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (!array[j].equals(targetElement)) {
                array[i] = array[j];
                i++;
            }
        }
        return i;
    }

    /**
     * Approach 02
     * when element to be moved is very less we do unnecessary copy's in 01
     * when current ith element is not equal to target element do i++
     * when current ith element is equal to target element replace the ith element with n-1 element and
     * n-- (so that we can skip the swapped target elements )
     * note: after swapping we are not increment i
     */
    public int removeElementFromArray02(String[] array, String targetElement) {
        int i = 0;
        int n = array.length;
        while (i < n) {
            if (array[i].equals(targetElement)) {
                array[i] = array[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return i;
    }
}

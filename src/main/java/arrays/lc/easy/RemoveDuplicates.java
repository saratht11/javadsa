package arrays.lc.easy;

import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {
    /**
     * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     */
    public static void main(String[] args) {
        RemoveDuplicates duplicates = new RemoveDuplicates();
        int[] nums = {1, 1, 1, 1, 2, 3, 4, 4, 5};
        System.out.println(duplicates.removeDuplicates(nums));
        //Result -> 5
        System.out.println(Arrays.toString(nums));
        //Result -> 1, 2, 3, 4, 5, 3, 4, 4, 5
    }

    /**
     * if ith element and jth element == just increment jth value.
     * if != increment ith value and assign current jth value to ith value.
     * Time complexity : O(n) n = length of array.  i and j traverses at most n steps.
     * Space complexity : O(1).
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

                /*
             RemoveDuplicates
            0, 1, 2, 3, 4, 5, 6, 7, 8
            1, 1, 1, 1, 2, 3, 4, 4, x   5

            0th!=1th
            0th!=2th
            0th!=3th
            !0th!=4th
            1, 2, 1, 1, 2, 3, 4, 4, 5
            !1th!=5th
            1, 2, 3, 1, 2, 3, 4, 4, 5
            !2nd!=6th
            1, 2, 3, 4, 2, 3, 4, 4, 5
            3rd!=7th
            !3rd!=8th
            1, 2, 3, 4, 5, 3, 4, 4, 5
                 */
}

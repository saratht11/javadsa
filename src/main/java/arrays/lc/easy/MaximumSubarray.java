package arrays.lc.easy;

import java.util.LinkedList;

/**
 * find the contiguous subarray which has the largest sum and return its sum.
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray subarray = new MaximumSubarray();
        int[] nums = { 2, -4, 1, 9, -6, 7, -3 };
        //     System.out.println(subarray.maxSubArrayNaive(nums));
        System.out.println(subarray.kadaneMaxSubArray(nums));
    }

    /**
     * Naive Solution
     * from i th element till nth element calculate the sum and i++
     * during every addition compare the current sum with the previous mav sum
     * if the current sum is greater then previous sum update the previous sum value with current sum
     * repeat this till 'i < n' fails
     * O(n2)
     */
    public int maxSubArrayNaive(int[] nums) {
        int maximumSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentMaximumSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentMaximumSum += nums[j];
                if (currentMaximumSum > maximumSum) {
                    maximumSum = currentMaximumSum;
                }
            }
        }
        return maximumSum;
    }

    public int kadaneMaxSubArray(int[] arr) {
        int maxSoFar = 0, maxEndingHere = 0;
        for (int j : arr) {
            maxEndingHere = Math.max(j, maxEndingHere + j);
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }
        return maxSoFar;
    }

}

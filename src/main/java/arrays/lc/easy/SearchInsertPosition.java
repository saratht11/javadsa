package arrays.lc.easy;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(searchInsertPosition.searchInsertNaive(nums, 6) + 1);
        System.out.println(searchInsertPosition.searchInsertUsingBinarySearch(nums, 6) + 1);
    }

    /**
     * Naive approach
     * if ith element is equal to target num return i
     * else if ith element is greater element return i
     * if end of the loop reached just return the length
     */
    public int searchInsertNaive(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            }
        }
        return n;
    }

    /**
     * Using Binary Search Because the array is Sorted.
     * if middle element is equal to target return middle element position
     * else if target element is less than middle element then search between 0 to mid element in the array
     * else if target element is greater than middle element then search between mid element and last element.
     */
    public int searchInsertUsingBinarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end + 1;
    }

}

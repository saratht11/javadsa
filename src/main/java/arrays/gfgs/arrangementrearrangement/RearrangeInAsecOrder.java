package arrays.gfgs.arrangementrearrangement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Rearrange the given array as 0 to n-1 if the element is not found in the array replace it with -1
 * https://www.geeksforgeeks.org/rearrange-array-arri/
 */
public class RearrangeInAsecOrder {
    public static void main(String[] args) {
        RearrangeInAsecOrder rearrange = new RearrangeInAsecOrder();
        int[] arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        //rearrange.naiveRearrangeArray(arr);
        //rearrange.rearrangeArray02(arr);
        //System.out.println(Arrays.toString(rearrange.rearrangeArrayUsingHS(arr)));
        rearrange.reverseArrayBySwap(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Naive Approach
     * if i is equal to arr[j] then swap the elements present in arr[i] and arr[j] and break (to avoid unnecessary lookup)
     * finally replace the missing value with -1.
     */
    public void naiveRearrangeArray(int[] arr) {
        int n = arr.length;
        int i, j, temp;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (arr[j] == i) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    break;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            if (arr[k] != k) {
                arr[k] = -1;
            }
        }
    }

    /**
     * Skip if ith element in an array is -1 or array[i] ==i
     * Think not applicable for all Scenarios
     */
    public void rearrangeArray02(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1 && arr[i] != i) {
                int x = arr[i];
                while (arr[x] != -1 && arr[x] != x) {
                    int y = arr[x];
                    arr[x] = x;
                    x = y;
                }
                arr[x] = x;
                if (arr[i] != i) {
                    arr[i] = -1;
                }
            }
        }
    }

    /**
     * Using Hash Set
     * insert elements inside hashset (elements will be inserted in asec order)
     * if i element present in set insert ith element as i
     * else -1
     */
    public int[] rearrangeArrayUsingHS(int[] arr) {
        Set<Integer> s = new HashSet<Integer>();
        for (int j : arr) {
            s.add(j);
        }
        for (int i = 0; i < arr.length; i++) {
            if (s.contains(i))
                arr[i] = i;
            else
                arr[i] = -1;
        }
        return arr;
    }

    /**
     * if ith element >=0 and ith element not equal to i
     * then swap array[ith element value]  value with ith element
     */
    public void reverseArrayBySwap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] != i) {
                int n = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = n;
            } else {
                i++;
            }
        }
    }
}

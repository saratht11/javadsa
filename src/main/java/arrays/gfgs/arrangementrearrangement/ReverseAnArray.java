package arrays.gfgs.arrangementrearrangement;

import java.util.Arrays;

/**
 * Reverse the array
 * https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 */
public class ReverseAnArray {
    public static void main(String[] args) {
        ReverseAnArray reverseAnArray = new ReverseAnArray();
        String[] array = {"S", "A", "R", "A", "T", "H"};
        //reverseAnArray.reverseArray(array);
        //reverseAnArray.reverseArrayRecursively(array, 0, array.length - 1);
        //System.out.println(Arrays.toString(array));
        //System.out.println(reverseAnArray.reverseInt(123987));
        System.out.println(reverseAnArray.reverseStringWithOutTemp("sarath".toCharArray()));
    }

    /**
     * swap the first element and last element
     */
    public void reverseArray(String[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            String tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * same approach as above but recursively
     */
    public void reverseArrayRecursively(String[] array, int start, int end) {
        if (start >= end) return;
        String tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
        reverseArrayRecursively(array, start + 1, end - 1);

    }

    /**
     * Simple Scenario
     * % will return last digit
     * while / will return digits except last.
     */
    public int reverseInt(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = (reversed * 10) + num % 10;
            num = num / 10;
        }
        return reversed;
    }

    /**
     * Handles edge case
     */
    public int reverseInt02(int num) {
        long reversed = 0;
        while (num != 0) {
            reversed = (reversed * 10) + num % 10;
            num = num / 10;
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) reversed;
    }

    public String reverseStringWithOutTemp(char[] input) {
        int start = 0;
        int end = input.length-1;
        while (start < end) {
            input[start] ^= input[end];
            input[end] ^= input[start];
            input[start] ^= input[end];
            ++start;
            --end;
        }
        return String.valueOf(input);
    }


}

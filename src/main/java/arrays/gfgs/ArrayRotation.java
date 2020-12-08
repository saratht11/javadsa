package arrays.gfgs;

import java.util.Arrays;

/**
 * Rotate an array of size n for d elements
 * https://www.geeksforgeeks.org/array-rotation/
 */
public class ArrayRotation {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        String[] arr = {"1", "2", "3", "4", " 5", "6", " 7 "};
        System.out.println(Arrays.toString(rotateArray.rotateUsingTempArray(arr, 1)));
        System.out.println(Arrays.toString(rotateArray.leftRotateOneByOne(arr, 1)));
        System.out.println(Arrays.toString(rotateArray.jugglingAlgorithmArrayRotation(arr, 3)));
        System.out.println(Arrays.toString(rotateArray.reversalAlgorithm(arr, 10)));
    }


    static class RotateArray {
        /**
         * Naive Solution
         * Store the array of d elements in a temp array
         * Shift the array original array
         * Store back the d element array
         * O(n+d)
         */
        public String[] rotateUsingTempArray(String[] array, int d) {
            String[] tempArray = new String[d];
            int k = 0, m = 0;
            for (int i = 0; i < d; i++) {
                tempArray[i] = array[i];
            }
            for (int j = d; j < array.length; j++) {
                array[k] = array[j];
                k++;
            }
            for (int l = array.length - d; l < array.length; l++) {
                array[l] = tempArray[m];
                m++;
            }
            return array;
        }

        /**
         * shorter solution in terms of code length
         * move one by one from left to right
         * O(n * d)
         */
        public String[] leftRotateOneByOne(String[] array, int d) {
            for (int i = 0; i < d; i++) {
                leftRotateByOne(array, array.length);
            }
            return array;
        }

        /**
         * assign the first element to temp,
         * move remaining element one step forward
         * assign the temp element at the end
         */
        private void leftRotateByOne(String[] array, int n) {
            String tmp = array[0];
            int i;
            for (i = 0; i < n - 1; i++) {
                array[i] = array[i + 1];
            }
            array[i] = tmp;
        }

        /**
         *
         */
        public String[] jugglingAlgorithmArrayRotation(String[] array, int d) {
            int n = array.length;
            d = d % n;
            int i, j, k;
            String temp;
            int gcd = gcd(d, n);
            for (i = 0; i < gcd; i++) {
                temp = array[i];
                j = i;
                while (true) {
                    k = j + d;
                    if (k >= n)
                        k = k - n;
                    if (k == i)
                        break;
                    array[j] = array[k];
                    j = k;
                }
                array[j] = temp;
            }
            return array;
        }

        /**
         * gcd based on euclid
         */
        int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        /**
         * split the array[0 to d-1] and array[d to n-1]
         * revere each set ones and finally reverse completely one more time totally 3 reverse
         */
        public String[] reversalAlgorithm(String[] array, int d) {
            // if d greater than array length
            d = d % array.length;
            reverseArray(array, 0, d - 1);
            reverseArray(array, d, array.length - 1);
            reverseArray(array, 0, array.length - 1);
            return array;
        }

        /**
         * Just swaps the element of array till the middle
         */
        void reverseArray(String[] array, int start, int end) {
            String temp;
            while (start < end) {
                temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }


    }

}

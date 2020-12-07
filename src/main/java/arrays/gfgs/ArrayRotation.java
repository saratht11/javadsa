package arrays.gfgs;

import java.util.Arrays;

/*
 *  Rotate an array of size n for d elements
 *  https://www.geeksforgeeks.org/array-rotation/
 * */
public class ArrayRotation {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        String[] arr = {"1", "2", "3", "4", " 5", "6", " 7 "};
        System.out.println(Arrays.toString(rotateArray.rotateUsingTempArray(arr, 1)));
        System.out.println(Arrays.toString(rotateArray.leftRotateOneByOne(arr, 1)));
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


    }

}

package Searching;

/**
 * https://www.geeksforgeeks.org/binary-search/
 */
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int p;
        //     p = search.binarySearch(array, 4);
        p = search.binarySearch(array, 0, array.length, 4);
        System.out.println(p);
    }

    /**
     * if the target present in tht middle return the m
     * else if the target is greater than m increase the value of i to m+1
     * else if the target is lesser than m decrease the value of l to m-1
     */
    public int binarySearch(int[] array, int target) {
        int i = 0, l = array.length - 1;
        while (i <= l) {
            int m = i + (l - i) / 2; // To Avoid OverFlow
            if (array[m] == target) return m;
            if (array[m] < target) {
                i = m + 1;
            } else if (array[m] > target) {
                l = m - 1;
            }
        }
        return -1;
    }

    /**
     * Same approach like above but recursively
     */
    public int binarySearch(int[] array, int i, int l, int target) {
        int m = i + (l - i) / 2; // To Avoid OverFlow
        if (array[m] == target) return m;
        if (array[m] < target) {
            i = m + 1;
            return binarySearch(array, i, l, target);
        } else if (array[m] > target) {
            l = m - 1;
            return binarySearch(array, i, l, target);
        }
        return -1;
    }
}

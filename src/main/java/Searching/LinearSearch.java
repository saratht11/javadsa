package Searching;

/**
 * https://www.geeksforgeeks.org/linear-search/
 */
public class LinearSearch {
    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        String[] array = {"a", "b", "c", "s", "x", "y", "z"};
        int position;
        position = linearSearch.linearSearch(array, "s");
        System.out.println(position + 1);
        position = linearSearch.linearSearchWithTwoPivot(array, "a");
        System.out.println(position + 1);

    }

    /**
     * Search from first till last if found return the position else return -1
     */
    public int linearSearch(String[] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (target.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Two pointer approach
     * One pointer starts from first and  Second pointer starts from last
     * return th position if found by any pointer
     * iterate till both the pointer meet at middle
     * else return -1 if not found
     */
    public int linearSearchWithTwoPivot(String[] array, String target) {
        int p = -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            if (array[left].equals(target)) {
                return left;
            }
            if (array[right].equals(target)) {
                return right;
            }
            right--;
            left++;
        }
        return p;
    }
}

package arrays.gfgs;

/**
 * https://www.geeksforgeeks.org/rotate-matrix-elements/
 */
public class RotateMatrixElements {
    public static void main(String[] args) {
        RotateMatrixElements matrixElements = new RotateMatrixElements();
        int[][] array = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        matrixElements.printMatrixElement(array);
        matrixElements.rotateClockWiseOnce(array, 4, 4);
        matrixElements.printMatrixElement(array);
    }

    /*
        1) Move elements of top row.
        2) Move elements of last column.
        3) Move elements of bottom row.
        4) Move elements of first column.
    Repeat above steps for inner ring while there is an inner ring.
     */
    private void rotateClockWiseOnce(int[][] matrix, int r, int c) {
        int row = 0, col = 0;
        int prev, curr;
        while (row < r && col < c) {
            if (row + 1 == r || col + 1 == c)
                break;
            prev = matrix[row + 1][col];
            for (int i = col; i < c; i++) {
                curr = matrix[row][i];
                matrix[row][i] = prev;
                prev = curr;
            }
            row++;
            for (int i = row; i < r; i++) {
                curr = matrix[i][c - 1];
                matrix[i][c - 1] = prev;
                prev = curr;
            }
            c--;
            if (row < r) {
                for (int i = c - 1; i >= col; i--) {
                    curr = matrix[r - 1][i];
                    matrix[r - 1][i] = prev;
                    prev = curr;
                }
            }
            r--;
            if (col < c) {
                for (int i = r - 1; i >= row; i--) {
                    curr = matrix[i][col];
                    matrix[i][col] = prev;
                    prev = curr;
                }
                col++;
            }

        }
    }

    private void printMatrixElement(int[][] matrixArray) {
        for (int[] row : matrixArray) {
            for (int cell : row) {
                System.out.printf("%d ", cell);
            }
            System.out.println();
        }
    }
}

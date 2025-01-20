
package Array;

import java.util.HashMap;

public class SmallestINdexToPaint {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;    // Number of rows in the matrix
        int n = mat[0].length; // Number of columns in the matrix

        // Maps to store the position of each number in the matrix
        HashMap<Integer, int[]> positionMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                positionMap.put(mat[i][j], new int[]{i, j});
            }
        }

        // Arrays to keep track of painted cells in rows and columns
        int[] rowPainted = new int[m];
        int[] colPainted = new int[n];

        // Process the array `arr` in order
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            int[] pos = positionMap.get(number); // Get the position of the number
            int row = pos[0];
            int col = pos[1];

            // Increment the counters for the row and column
            rowPainted[row]++;
            colPainted[col]++;

            // Check if the current row or column is fully painted
            if (rowPainted[row] == n || colPainted[col] == m) {
                return i; // Return the index as soon as a row or column is fully painted
            }
        }

        // If no row or column is fully painted, return -1 (shouldn't happen in this problem)
        return -1;
    }

    public static void main(String[] args) {
        SmallestINdexToPaint solver = new SmallestINdexToPaint();

        // Example 1
        int[] arr1 = {1, 3, 4, 2};
        int[][] mat1 = {{1, 4}, {2, 3}};
        System.out.println(solver.firstCompleteIndex(arr1, mat1)); // Output: 2

        // Example 2
        int[] arr2 = {2, 8, 7, 4, 1, 3, 5, 6, 9};
        int[][] mat2 = {{3, 2, 5}, {1, 4, 6}, {8, 7, 9}};
        System.out.println(solver.firstCompleteIndex(arr2, mat2)); // Output: 3
    } 
}

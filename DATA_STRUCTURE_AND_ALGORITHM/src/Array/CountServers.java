
package Array;

public class CountServers {
     public int countServers(int[][] grid) {
        int m = grid.length;    // Number of rows
        int n = grid[0].length; // Number of columns
        
        int[] rowCount = new int[m]; // Count of servers in each row
        int[] colCount = new int[n]; // Count of servers in each column
        
        // Step 1: Count servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        // Step 2: Count the servers that can communicate
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        CountServers solution = new CountServers();
        
        // Example 1
        int[][] grid1 = {{1, 0}, {0, 1}};
        System.out.println("Example 1 Output: " + solution.countServers(grid1)); // Expected output: 0

        // Example 2
        int[][] grid2 = {{1, 0}, {1, 1}};
        System.out.println("Example 2 Output: " + solution.countServers(grid2)); // Expected output: 3

        // Example 3
        int[][] grid3 = {
            {1, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        System.out.println("Example 3 Output: " + solution.countServers(grid3)); // Expected output: 4
    } 
}

package Array;

public class GridGame {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] prefixTop = new long[n + 1]; // Prefix sum for top row
        long[] prefixBottom = new long[n + 1]; // Prefix sum for bottom row
        
        // Compute prefix sums for top and bottom rows
        for (int i = 0; i < n; i++) {
            prefixTop[i + 1] = prefixTop[i] + grid[0][i];
            prefixBottom[i + 1] = prefixBottom[i] + grid[1][i];
        }
        
        long result = Long.MAX_VALUE;
        
        // Iterate through each column to consider it as a splitting point
        for (int i = 0; i < n; i++) {
            // Points remaining in the top row if Robot 1 moves down after this column
            long topRemaining = prefixTop[n] - prefixTop[i + 1];
            // Points collected in the bottom row if Robot 1 moves down before this column
            long bottomCollected = prefixBottom[i];
            
            // Maximum points Robot 2 can collect based on the split
            long maxPointsRobot2 = Math.max(topRemaining, bottomCollected);
            result = Math.min(result, maxPointsRobot2); // Minimize the maximum points Robot 2 collects
        }
        
        return result;
    }
    public static void main(String[] args) {
        GridGame solution = new GridGame();

        // Example 1
        int[][] grid1 = {{2, 5, 4}, {1, 5, 1}};
        System.out.println("Example 1 Output: " + solution.gridGame(grid1)); // Expected Output: 4

        // Example 2
        int[][] grid2 = {{3, 3, 1}, {8, 5, 2}};
        System.out.println("Example 2 Output: " + solution.gridGame(grid2)); // Expected Output: 4

        // Example 3
        int[][] grid3 = {{1, 3, 1, 15}, {1, 3, 3, 1}};
        System.out.println("Example 3 Output: " + solution.gridGame(grid3)); // Expected Output: 7

        // Additional Test Case
        int[][] grid4 = {{10, 10, 10, 10}, {5, 5, 5, 5}};
        System.out.println("Additional Test Case Output: " + solution.gridGame(grid4)); // Expected Output: 15
    }
}

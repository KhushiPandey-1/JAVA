package Array;

public class MaxFish {
    int m, n;
    int[] dir = {-1, 0, 1, 0, -1}; // To move in 4 directions: up, right, down, left

    private int dfs(int[][] grid, int i, int j) {
        // Base case: check if out of bounds or on a land cell
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        // Collect fish from the current cell
        int sum = grid[i][j];
        grid[i][j] = 0; // Mark the cell as visited by setting it to 0

        // Explore all 4 directions
        for (int k = 0; k < 4; k++) {
            sum += dfs(grid, i + dir[k], j + dir[k + 1]);
        }

        return sum;
    }

    public int findMaxFish(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxFish = 0;

        // Iterate through all cells in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If it's a water cell, start DFS and calculate the total fish
                if (grid[i][j] > 0) {
                    maxFish = Math.max(maxFish, dfs(grid, i, j));
                }
            }
        }

        return maxFish;
    }

    public static void main(String[] args) {
       MaxFish sol = new MaxFish();

        int[][] grid1 = {
            {0, 2, 1, 0},
            {4, 0, 0, 3},
            {1, 0, 0, 4},
            {0, 3, 2, 0}
        };
        System.out.println(sol.findMaxFish(grid1)); // Output: 7

        int[][] grid2 = {
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 1}
        };
        System.out.println(sol.findMaxFish(grid2)); // Output: 1
    } 
}

package Heap;

import java.util.PriorityQueue;

public class TrapRainwaterII {

     static class Cell {
        int x, y, height;

        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Add all boundary cells to the min-heap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    minHeap.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        // Directions for moving up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int waterTrapped = 0;

        // Process the cells in the min-heap
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            for (int[] dir : directions) {
                int nx = cell.x + dir[0];
                int ny = cell.y + dir[1];

                // Skip invalid or already visited cells
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }

                // Calculate trapped water
                waterTrapped += Math.max(0, cell.height - heightMap[nx][ny]);

                // Update the cell height to the max of the current cell or neighbor
                minHeap.offer(new Cell(nx, ny, Math.max(heightMap[nx][ny], cell.height)));
                visited[nx][ny] = true;
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        TrapRainwaterII  solution = new TrapRainwaterII ();

        int[][] heightMap1 = {
            {1, 4, 3, 1, 3, 2},
            {3, 2, 1, 3, 2, 4},
            {2, 3, 3, 2, 3, 1}
        };
        System.out.println(solution.trapRainWater(heightMap1)); // Output: 4

        int[][] heightMap2 = {
            {3, 3, 3, 3, 3},
            {3, 2, 2, 2, 3},
            {3, 2, 1, 2, 3},
            {3, 2, 2, 2, 3},
            {3, 3, 3, 3, 3}
        };
        System.out.println(solution.trapRainWater(heightMap2)); // Output: 10
    }
    
}

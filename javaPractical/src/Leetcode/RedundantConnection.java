package Leetcode;

public class RedundantConnection {
     class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n + 1]; // 1-based index
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i; // Each node is its own parent initially
                rank[i] = 1; // Initial rank is 1
            }
        }

        // Find with path compression
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        // Union by rank
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false; // Cycle detected
            }

            // Union by rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge; // This edge is the redundant one
            }
        }

        return new int[0]; // Should never reach here
    }

    // Example usage
    public static void main(String[] args) {
        RedundantConnection sol = new RedundantConnection();
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};

        System.out.println(java.util.Arrays.toString(sol.findRedundantConnection(edges1))); // Output: [2, 3]
        System.out.println(java.util.Arrays.toString(sol.findRedundantConnection(edges2))); // Output: [1, 4]
    }
}

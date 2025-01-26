package Array;

import java.util.*;

public class LexicographicallySmallestArray {
    class Solution {
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            int n = nums.length;

            // Edge case: Directly sort if array has 1 or fewer elements
            if (n <= 1) return nums;

            // Create value-index pairs and sort by values
            List<int[]> valueIndexPairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                valueIndexPairs.add(new int[]{nums[i], i});
            }
            valueIndexPairs.sort(Comparator.comparingInt(a -> a[0]));

            // Union-Find to group indices
            UnionFind uf = new UnionFind(n);

            // Process the sorted values and merge indices within the limit
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n && valueIndexPairs.get(j)[0] - valueIndexPairs.get(i)[0] <= limit; j++) {
                    uf.union(valueIndexPairs.get(i)[1], valueIndexPairs.get(j)[1]);
                }
            }

            // Group indices by their root
            Map<Integer, List<Integer>> components = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int root = uf.find(i);
                components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
            }

            // Sort and reassign values within each component
            for (List<Integer> indices : components.values()) {
                List<Integer> values = new ArrayList<>();
                for (int index : indices) {
                    values.add(nums[index]);
                }
                Collections.sort(values);
                Collections.sort(indices);
                for (int i = 0; i < indices.size(); i++) {
                    nums[indices.get(i)] = values.get(i);
                }
            }

            return nums;
        }

        // Union-Find implementation with path compression
        class UnionFind {
            private int[] parent, rank;

            public UnionFind(int n) {
                parent = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]); // Path compression
                }
                return parent[x];
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX != rootY) {
                    if (rank[rootX] > rank[rootY]) {
                        parent[rootY] = rootX;
                    } else if (rank[rootX] < rank[rootY]) {
                        parent[rootX] = rootY;
                    } else {
                        parent[rootY] = rootX;
                        rank[rootX]++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        LexicographicallySmallestArray obj = new LexicographicallySmallestArray();
        Solution solution = obj.new Solution();

        int[] nums1 = {5, 5, 5, 6};
        int limit1 = 3;
        System.out.println(Arrays.toString(solution.lexicographicallySmallestArray(nums1, limit1)));

        int[] nums2 = {1, 7, 6, 18, 2, 1};
        int limit2 = 3;
        System.out.println(Arrays.toString(solution.lexicographicallySmallestArray(nums2, limit2)));

        int[] nums3 = {1, 7, 28, 19, 10};
        int limit3 = 3;
        System.out.println(Arrays.toString(solution.lexicographicallySmallestArray(nums3, limit3)));
    }
}

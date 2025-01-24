package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SafeNodes {
     public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        // Step 1: Reverse the graph and calculate in-degrees
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) reverseGraph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph.get(neighbor).add(i);
                inDegree[i]++;
            }
        }

        // Step 2: Perform topological sorting using a queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        // Step 3: Collect safe nodes
        boolean[] isSafe = new boolean[n];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            isSafe[node] = true; // Mark the node as safe

            for (int neighbor : reverseGraph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.add(neighbor);
            }
        }

        // Step 4: Collect and sort all safe nodes
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe[i]) result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        SafeNodes solution = new SafeNodes();
        int[][] graph1 = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        int[][] graph2 = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};

        System.out.println(solution.eventualSafeNodes(graph1)); // Output: [2, 4, 5, 6]
        System.out.println(solution.eventualSafeNodes(graph2)); // Output: [4]
    }
}


package TYPES_OF_SORTING;
public class MinimumInvitations {
 public static int maximumInvitations(int[] favorite) {
        int n = favorite.length;

        // Step 1: Initialize arrays
        int[] inDegree = new int[n];  // Array to store in-degrees
        int[] queue = new int[n];    // Queue for topological sorting
        int[] depth = new int[n];    // Depth array to store chain lengths

        // Step 2: Count in-degrees
        for (int i = 0; i < n; i++) {
            inDegree[favorite[i]]++;
        }

        // Step 3: Process chains using topological sorting
        int left = 0, right = 0;  // Pointers for the queue
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue[right++] = i;  // Add nodes with in-degree 0
        }

        while (left < right) {
            int current = queue[left++];  // Remove node from queue
            int next = favorite[current];  // Follow the edge to the next node
            depth[next] = Math.max(depth[next], depth[current] + 1);  // Update chain length
            if (--inDegree[next] == 0) {  // Reduce in-degree of the next node
                queue[right++] = next;
            }
        }

        // Step 4: Process cycles and calculate results
        int smallCircleSum = 0;  // Sum of lengths of chains and 2-cycles
        int maxCycle = 0;        // Maximum cycle length for larger cycles

        for (int i = 0; i < n; i++) {
            if (inDegree[i] != 0) {  // Node is part of a cycle
                inDegree[i] = 0;  // Mark node as visited
                int count = 1;  // Count the cycle size
                for (int j = favorite[i]; j != i; j = favorite[j]) {
                    count++;
                    inDegree[j] = 0;  // Mark all nodes in the cycle as visited
                }

                if (count == 2) {  // Special case: 2-cycle
                    smallCircleSum += depth[i] + depth[favorite[i]] + 2;
                } else {  // Larger cycles
                    maxCycle = Math.max(maxCycle, count);
                }
            }
        }

        return Math.max(maxCycle, smallCircleSum);  // Return the maximum result
    }

    // Example usage
    public static void main(String[] args) {
        int[] favorite1 = {2, 2, 1, 2};
        System.out.println(maximumInvitations(favorite1)); // Output: 3

        int[] favorite2 = {1, 2, 0};
        System.out.println(maximumInvitations(favorite2)); // Output: 3

        int[] favorite3 = {3, 0, 1, 4, 1};
        System.out.println(maximumInvitations(favorite3)); // Output: 4
    }
    
}

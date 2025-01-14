package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class PrefixComArray {

    public static int[] findPrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        Set<Integer> seenInA = new HashSet<>();
        Set<Integer> seenInB = new HashSet<>();
        
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            // Add current elements to their respective sets
            if (seenInB.contains(A[i])) {
                commonCount++;
            }
            seenInA.add(A[i]);

            if (seenInA.contains(B[i])) {
                commonCount++;
            }
            seenInB.add(B[i]);

            // Update result for current index
            result[i] = commonCount;
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1
        int[] A1 = {1, 3, 2, 4};
        int[] B1 = {3, 1, 2, 4};
        System.out.println(Arrays.toString(findPrefixCommonArray(A1, B1))); // Output: [0, 2, 3, 4]

        // Example 2
        int[] A2 = {2, 3, 1};
        int[] B2 = {3, 1, 2};
        System.out.println(Arrays.toString(findPrefixCommonArray(A2, B2))); // Output: [0, 1, 3]
    }
    
}

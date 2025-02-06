package Array;
import java.util.*;
public class TupleCnt {
     public static int countValidTuples(int[] nums) {
        Map<Integer, Integer> productMap = new HashMap<>();
        int count = 0;

        // Compute all pairs (a, b)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];

                // If the product already exists, add to count
                if (productMap.containsKey(product)) {
                    count += 8 * productMap.get(product);
                }

                // Update product count in map
                productMap.put(product, productMap.getOrDefault(product, 0) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4, 6};
        System.out.println(countValidTuples(nums1)); // Output: 8

        int[] nums2 = {1, 2, 4, 5, 10};
        System.out.println(countValidTuples(nums2)); // Output: 16
    }
}

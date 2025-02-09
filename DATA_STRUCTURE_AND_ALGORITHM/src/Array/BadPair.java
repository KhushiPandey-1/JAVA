package Array;

public class BadPair {
   import java.util.HashMap;

public class BadPairsCounter {
    public static long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2; // Total possible pairs
        
        HashMap<Integer, Long> countMap = new HashMap<>();
        long goodPairs = 0;

        for (int i = 0; i < n; i++) {
            int diff = i - nums[i]; // Compute transformed value
            goodPairs += countMap.getOrDefault(diff, 0L); // Count good pairs
            countMap.put(diff, countMap.getOrDefault(diff, 0L) + 1); // Update frequency
        }

        return totalPairs - goodPairs; // Bad pairs = total pairs - good pairs
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 3, 3};
        System.out.println(countBadPairs(nums1)); // Output: 5

        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(countBadPairs(nums2)); // Output: 0
    }
}
 
}

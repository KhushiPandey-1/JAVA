package Array;

public class LongestSubarrayProblem {
  public int longestMonoSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        int inc = 1; // current strictly increasing subarray length
        int dec = 1; // current strictly decreasing subarray length
        
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
            } else {
                inc = 1;
            }
            
            if (nums[i] < nums[i - 1]) {
                dec++;
            } else {
                dec = 1;
            }
            
            maxLen = Math.max(maxLen, Math.max(inc, dec));
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        LongestSubarrayProblem sol = new LongestSubarrayProblem();
        
        int[] nums1 = {1, 4, 3, 3, 2};
        int[] nums2 = {3, 3, 3, 3};
        int[] nums3 = {3, 2, 1};
        
        System.out.println("Example 1 Output: " + sol.longestMonoSubarray(nums1)); // Output: 2
        System.out.println("Example 2 Output: " + sol.longestMonoSubarray(nums2)); // Output: 1
        System.out.println("Example 3 Output: " + sol.longestMonoSubarray(nums3)); // Output: 3
    }    
}

package Array;
public class maxSumOfSubarray {
    public static int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {10, 20, 30, 5, 10, 50};
        int[] nums2 = {10, 20, 30, 40, 50};
        int[] nums3 = {12, 17, 15, 13, 10, 11, 12};
        
        System.out.println("Output 1: " + maxAscendingSum(nums1)); // Output: 65
        System.out.println("Output 2: " + maxAscendingSum(nums2)); // Output: 150
        System.out.println("Output 3: " + maxAscendingSum(nums3)); // Output: 33
    }
}

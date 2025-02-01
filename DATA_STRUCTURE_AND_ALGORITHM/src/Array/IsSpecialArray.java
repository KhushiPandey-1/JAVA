package Array;

public class IsSpecialArray {
   public static boolean isSpecialArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // Check if both are even or both are odd
            if ((nums[i] % 2 == nums[i + 1] % 2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {2, 1, 4};
        int[] nums3 = {4, 3, 1, 6};

        System.out.println(isSpecialArray(nums1)); // true
        System.out.println(isSpecialArray(nums2)); // true
        System.out.println(isSpecialArray(nums3)); // false
    } 
}

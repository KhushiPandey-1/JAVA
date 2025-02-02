package Array;

public class ArraySortedAndRotated {
     public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySortedAndRotated sol = new ArraySortedAndRotated();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(sol.check(nums1)); // Output: true

        int[] nums2 = {2, 1, 3, 4};
        System.out.println(sol.check(nums2)); // Output: false

        int[] nums3 = {1, 2, 3};
        System.out.println(sol.check(nums3)); // Output: true
    }
}

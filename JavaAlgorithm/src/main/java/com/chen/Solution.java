

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int removeDuplicatesAndSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Set<Integer> seen = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!seen.add(nums[i])) { // If the number is already seen, it's a duplicate
                sum += nums[i]; // Add the duplicate number to the sum
                // Remove the duplicate element from the array
                System.arraycopy(nums, i + 1, nums, i, nums.length - i - 1);
                nums = Arrays.copyOf(nums, nums.length - 1); // Reduce the size of the array
                i--; // Stay at the same index to check the next element after the removal
            }
        }

        return seen.size() == nums.length ? -1 : sum; // If no duplicates were found, return -1
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 5, 5, 6};
        int result = removeDuplicatesAndSum(nums);
        System.out.println("Sum of removed duplicates: " + result);
        // Output the array without duplicates for verification
        System.out.println("Array without duplicates: " + Arrays.toString(nums));
    }
}

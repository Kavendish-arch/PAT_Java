package com.chen.twopointer;

import java.util.HashSet;
import java.util.Set;

public class DelArr {

    public static int delArr(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Set<Integer> seen = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!seen.add(nums[i])) {
                sum += nums[i]; // Add the duplicate number to the sum
            }
        }
        // return Collections.sum(nums) - coll
        return seen.size() == nums.length ? -1 : sum; // If no duplicates were found, return -1
    }

    public static void main(String[] args) {
        // int[] nums = {1, 2, 3, 2, 4, 5, 5, 6};
        int[] nums = {1, 2, 2, 3, 4};
        int result = delArr(nums);
        System.out.println("Sum of removed duplicates: " + result);
        // Output the array without duplicates for verification
        // System.out.println("Array without duplicates: " + Arrays.toString(nums));
    }
}

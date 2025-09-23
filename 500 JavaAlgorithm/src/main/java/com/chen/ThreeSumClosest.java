package com.chen;

import java.util.Arrays;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package com.chen
 * @className com.chen.ThreeSumClosest
 * @date 2025/3/23 19:43
 * @description @todo
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0]  + nums[1]  + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复元素（优化点）
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 找到更接近的解时更新
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                // 指针移动策略
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return target; // 直接命中目标值
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }
}

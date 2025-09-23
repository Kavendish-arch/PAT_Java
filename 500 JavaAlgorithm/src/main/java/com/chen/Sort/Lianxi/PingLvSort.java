package com.chen.Sort.Lianxi;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName 排序
 * @package Lianxi
 * @className Lianxi.PingLvSort
 * @date 2024/10/29 13:24
 * @description 1636. 按照频率将数组升序排序
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。
 * 如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * 请你返回排序后的数组。
 */
public class PingLvSort {
    /*
    1 <= nums.length <= 100
    -100 <= nums[i] <= 100
     */
    public int[] frequencySort(int[] nums) {
        int max = 100;
        int min = -100;
        int[] count = new int[max - min + 1]; // 统计
        ArrayList<Integer>[] lists = new ArrayList[nums.length + 2];

        // 1. 统计出现次数
        for (int i : nums) {
            count[i - min]++;
        }

        // 初始化
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        // 2. 比较器
//        Arrays.stream(nums).boxed().sorted((a, b)->{
//            int af = count[a + min];
//            int bf = count[b + min];
//            if (af > bf) {
//                return 1;
//            } else if(af < bf) {
//                return -1;
//            } else {
//                return b - a;
//            }
//        }).mapToInt(Integer::intValue);

        for (int i = 0; i < count.length; i++) {
            int c = count[i];
            for (int j = 0; j < count[i]; j++) {
                lists[c].add(i + min);
            }
        }

        int k = 0;
//        for (int i = 0; i < lists.length; i++) {
//            System.out.println("出现" + i + " 次" + lists[i]);
//        }

        for (ArrayList<Integer> list : lists) {
            list.sort((o1, o2) -> {
                return  o2 - o1;
            });
            for (Integer integer : list) {
                nums[k++] = integer;
            }
        }

        return nums;
    }

    public int[] frequencySort2(int[] nums) {
        int max = 100;
        int min = -100;
        int[] count = new int[max - min + 1]; // 统计

        // 1. 统计出现次数
        for (int i : nums) {
            count[i - min]++;
        }
        // 2. 比较器
        return Arrays.stream(nums).boxed().sorted((a, b)->{
            int af = count[a - min];
            int bf = count[b - min];
            if (af > bf) {
                return 1;
            } else if(af < bf) {
                return -1;
            } else {
                return b - a;
            }
        }).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2, 2, 2, 3};
        int[] nums = {2,3,1,3,2};
        PingLvSort pingLvSort = new PingLvSort();
//        pingLvSort.frequencySort(nums);
//        System.out.println(Arrays.toString(nums));
        nums = pingLvSort.frequencySort2(nums);
        System.out.println(Arrays.toString(nums));
    }
}

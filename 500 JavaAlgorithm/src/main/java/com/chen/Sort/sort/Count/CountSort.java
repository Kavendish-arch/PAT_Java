package com.chen.Sort.sort.Count;

import java.util.Arrays;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName 排序
 * @package sort.Count
 * @className sort.Count.CountSort
 * @date 2024/10/28 13:37
 * @description 计数排序
 * 1. 找到最大值
 * 2. Count数组
 */
public class CountSort {
    /*
    要点
    1.找到最大值，创建一个大小为 最大值+1 的 count 数组
    2.count 数组的索引对应原始数组的元素，用来统计该元素的出现次数
    3.遍历 count 数组，根据 count 数组的索引(即原始数组的元素)以及出现次数，生成排序后内容
    count 数组的索引是:已排序好的

    前提:待排序元素>=0 且最大值不能太大

    改进：

     */
    public static void sortArray(int[] nums)
    {
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int minValue = Arrays.stream(nums).min().getAsInt();
        if(minValue < 0)
        {
            throw new RuntimeException("待排序元素不能小于0");
            // 最小值映射到0  最大值为 max - min
        }
        int[] count = new int[maxValue + 1];
        for (int num : nums) {
            count[num]++;
        }
        int j = 0;
        for(int i = 0; i < count.length; i++){
            while (count[i] > 0)
            {
                count[i]--;
                nums[j++] = i;
            }
        }
    }

    public static void sortArray2(int[] nums)
    {
        int maxValue = 5 * 10000 + 1;
        int minValue = -1 * 5 * 10000;
        int padding = 0;
        if(minValue < 0)
        {
            padding = -minValue;
        }
        int[] count = new int[maxValue + padding + 1];
        for (int num : nums) {
            count[num + padding]++;
        }
        System.out.println(Arrays.toString(count));
        int j = 0;
        for(int i = 0; i < count.length; i++){
            while (count[i] > 0)
            {
                count[i]--;
                nums[j++] = i - padding;
            }
        }
    }

    public static void main(String[] args){
//        int[] nums = {1, 5, 3, 6, 7, 8, 4, 2, 9, 0, 0, 0, 0, -1, -2, -3};
        int[] nums = {1, 5, 3, 6, 4, 7, 8,};
        sortArray2(nums);
        System.out.println(Arrays.toString(nums));
    }

}

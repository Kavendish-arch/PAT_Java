package com.chen.Sort.sort.Select;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName 排序
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME.sort.Select.SelectSort
 * @date 2024/10/26 22:01
 * @description 选择排序
 */
public class SelectSort {
    public static void selectSort(int[] nums)
    {
        // 基于最小值
        int min;
        // 选择的轮数
        for (int i = 0; i < nums.length - 1; i++)
        {
            min = i;
            for (int j = i + 1; j < nums.length; j++)
            {
                if (compare(nums[j], nums[min]))
                {
                    min = j;
                }
            }
            if(nums[i] == nums[min]){
                continue;
            }
            swap(nums, i, min);
//            int temp = nums[i];
//            nums[i] = nums[min];
//            nums[min] = temp;
        }
    }
    public static boolean compare(int a, int b)
    {
//        return a < b;
        return a > b;
    }

    public static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] nums = { 5, 3, 8, 6, 7, 2 };
        selectSort(nums);
        for (int i : nums)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

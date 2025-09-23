package com.chen.Sort.sort.merge;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName 排序
 * @package sort.merge
 * @className sort.merge.MergeList
 * @date 2024/10/27 22:11
 * @description 合并有序数组的方法
 */
public class MergeList {
    public static void merge(int[] arr, int[] arr2, int low, int mid, int high) {
        /**
         * arr [low,high]
         * [low,mid]
         * [mid+1,high]
         * a2 临时数组
         * 合并有序数组
         */
        int left = low, right = mid + 1, k = low;
        for(; k <= high; k++)
        {
            if(left > mid)
            {
                arr2[k] = arr[right++];
                continue;
            }
            if(right > high)
            {
                arr2[k] = arr[left++];
                continue;
            }
            if(arr[left] < arr[right])
            {
                arr2[k] = arr[left++];
            } else {
                arr2[k] = arr[right++];
            }
        }

    }
}

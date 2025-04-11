package com.chen.Sort.sort.merge;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName 排序
 * @package sort.merge
 * @className sort.merge.MergeSort
 * @date 2024/10/27 22:05
 * @description 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 6, 7, 8, 9, 10, 11, 12,};
        mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }




    public static void mergeSort(int[] arr) {
        int[] arr2 = new int[arr.length];
        split(arr, arr2, 0, arr.length - 1);
    }

    public static void merge(int[] arr, int[] arr2, int low, int mid, int high) {
        /**
         * arr [low,high]
         * [low,mid]
         * [mid+1,high]
         * a2 临时数组
         * 合并有序数组
         */
        int left = low, right = mid + 1, k = low;
        for (; k <= high; k++) {
            if (left > mid) {
                arr2[k] = arr[right++];
                continue;
            }
            if (right > high) {
                arr2[k] = arr[left++];
                continue;
            }
            if (arr[left] < arr[right]) {
                arr2[k] = arr[left++];
            } else {
                arr2[k] = arr[right++];
            }
        }

    }

    public static void split(int[] arr, int[] arr2, int low, int high) {
        if (low >= high) {
            // 2. 治疗
            return;
        }
//            int[] temp = Arrays.copyOfRange(arr, low, high + 1);
//            System.out.println(Arrays.toString(temp));
        // 1. 分
        int mid = (low + high) >>> 1;
        split(arr, arr2, low, mid);
        split(arr, arr2, mid + 1, high);
        merge(arr, arr2, low, mid, high);
        System.arraycopy(arr2, low, arr, low, high - low + 1);
    }

    //非递归方式
    public static void mergeSort2(int[] arr) {
        /**
         * 非递归方法
         */
        int len = arr.length;
        int[] arr2 = new int[len];
        // 归并排序规律
        for (int i = 1; i < len; i <<= 1) {
            // 1 2 4 8
            for (int left = 0; left < len; left += i * 2) {
                /***
                 * [0, 1] [2, 3], [4, 5], [6, 7], [8, 9], [10, 11], [12, 13]
                 * [0, 4], [5, 9], [10, 13]
                 * [0, 9] [10, 13]
                 * [0, 13]
                 */
                int right = Math.min(left + i * 2 - 1, len - 1);
//                System.out.println("left:" + left + " right:" + right);
                merge(arr, arr2, left, left + i - 1, right);
                System.arraycopy(arr2, left, arr, left, right - left + 1);
            }
        }

    }

    @Test
    public void testMergeSort2() {
        int[] arr = {5, 4, 3, 2, 1, 6, 7, 8, 9, 10, 11, 12,};
        mergeSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}

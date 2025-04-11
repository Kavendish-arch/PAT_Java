package com.chen.Sort.sort.quick;

//import org.junit.Test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName 排序
 * @package sort.quick
 * @className sort.quick.QuickSort
 * @date 2024/10/28 11:59
 * @description 快速排序
 * 单边快排
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 6, 7, 8, 4, 2, 9, 0};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    @Test
    public void testPartition1(){
        int[] arr = {1, 5, 3, 6, 7, 8, 4, 2, 9, 0};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    @Test
    public void testPartition2(){
        int[] arr = {1, 5, 3, 6, 7, 8, 4, 2, 9, 0};
        quickSort2(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void testPartition3(){
        int[] arr = {5,1,1,2,0,0};
        quickSort3(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        // [0, 1, 0, 1, 2, 5]
    }

    @Test
    public void testPartition4(){
//        int[] arr = {5,1,1,2,0,0};
        int[] arr = {5, 4, 3, 2,1 };
        quickSort4(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
    public static void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition2(arr, left, right);
            // * 基准点不均匀，防止最坏情况
            /*
            左边，右边没有平均分
             */
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
    public static void quickSort3(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition3(arr, left, right);
            // * 基准点不均匀，防止最坏情况
            /*
            左边，右边没有平均分
             */
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
    public static void quickSort4(int[] arr, int left, int right) {
        // 优化重复元素
        if (left < right) {
            int pivot = partition4(arr, left, right);
            int[] tmp = Arrays.copyOfRange(arr, left, right + 1);
            System.out.println(Arrays.toString(tmp) + " " + pivot);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
    public static int partition(int[] arr, int left, int right) {
        /**
         * 单边快排
         */
        int pivot = arr[right];
        int i = left;
        int j = left;
        while (j < right){
            if(arr[j] < pivot)
            {
                if(i != j)
                {
                    swap(arr, i, j);
                }
                i++;
            }
            j++;
        }
        swap(arr, i, right);
        return i;
    }
    public static int partition2(int[] arr, int left, int right) {
        /*
        * 双边快排
        * 1. 内层循环
        * 2. 为什么要先处理j ,后处理i
        * 3. 建议随机元素，作为基准点
         */
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            // j 从右向左找小于pivot的数
            while (i < j && arr[j] > pivot)
            {
                j--;
            }
            // i 从左向右找大于pivot的数
            while (i < j && arr[i] <= pivot)
            {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, left);
        return i;
    }

    public static int partition3(int[] arr, int left, int right) {
        /*
         * 双边快排 随机元素
         * 1. 内层循环
         * 2. 为什么要先处理j ,后处理i
         * 3. 建议随机元素，作为基准点
         * 4. 如果有大量重复元素会怎么样
         */
        // left right  = right - left + 1 + left
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(arr, left, idx);
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            // j 从右向左找小于pivot的数
            while (i < j && arr[j] > pivot)
            {
                j--;
            }
            // i 从左向右找大于pivot的数
            while (i < j && arr[i] <= pivot)
            {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, left);
        return i;
    }

    public static int partition4(int[] arr, int left, int right) {
        /*
         * 双边快排 随机元素
         * 1. 内层循环
         * 2. 为什么要先处理j ,后处理i
         * 3. 建议随机元素，作为基准点
         * 4. 如果有大量重复元素会怎么样 ***
         */
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(arr, left, idx);

        int pivot = arr[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {

            // i 从左向右找大于pivot的数
            while (i <= j && arr[i] < pivot)
            {
                i++;
            }
            // j 从右向左找小于pivot的数
            while (i <= j && arr[j] > pivot)
            {
                j--;
            }
            if(i <= j)
            {
                // 遇到想等元素，都停下
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        swap(arr, j, left);
        return j;
    }



    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public static List<> quickSort(List<Integer> list) {
//        // 排序方法
//        // 数据校验
//        /**
//         * 1. 数据校验
//         * 2. 比较策略
//         * 3.
//         */
//        if (left < right) {
//            int pivot = partition(list, left, right);
//            quickSort(list, left, pivot - 1);
//            quickSort(list, pivot + 1, right);
//        }
//        return list;
//    }

    public static void pattern(List<Integer> list, int left, int right){

    }

}

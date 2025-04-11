package com.chen.Sort.sort.Insert;

/**
 * 希尔排序，改进插入排序
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        int n = arr.length;
        // boolean flag = true;
        for (int gap = n / 2; gap >= 1; gap /= 2) {
            shellSortdk(arr, gap);
            if (isOrderAsc(arr) || isOrderDesc(arr)) {
//                System.out.println("完成");
//                for (int i : arr) {
//                    System.out.print(i + " ");
//                }
//                System.out.println();
                return;
//            } else {

                // Arrays.stream(arr).forEach(System.out::prinln);
//                for (int i : arr) {
//                    System.out.print(i + " ");
//                }
//                System.out.println();
            }
        }
    }

    public static boolean isOrderAsc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
            // 检测 <= 递增
        }
        return true;
    }

    public static boolean isOrderDesc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
            //检测>= 递减
        }
        return true;
    }

    public static void shellSortdk(int[] arr, int dk) {
        int n = arr.length;
        for (int i = dk; i < n; i++) {
            if (arr[i] > arr[i - dk]) {
                continue;
            }
//            if (arr[i] < arr[i - dk] ) {
            int tmp = arr[i];
            int j = i - dk;
            // 自右向左查找，比插入元素小的右移动
            while (j >= 0 && arr[j] > tmp) {
                arr[j + dk] = arr[j];
                j -= dk;
            }
            // 将插入元素插入
            if (j != i - dk) {
                arr[j + dk] = tmp;
            }
        }
    }

    public static void shellSort2(int[] arr) {
        // gap变小
        // 越有序，插入排序越快
        int n = arr.length;
        // boolean flag = true;
        for (int gap = n / 2; gap >= 1; gap /= 2) {
            shellSortdk(arr, gap);
            if (isOrderAsc(arr) || isOrderDesc(arr)) {
                return;
            }
        }
    }

//    public

    public static void main(String[] args) {
        //生成一个无序的数组
        int[] arr = {12, 34, 54, 2, 3, 87, 34, 99, 12, 56,};
        shellSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

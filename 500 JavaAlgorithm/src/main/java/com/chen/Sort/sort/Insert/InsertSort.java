package com.chen.Sort.sort.Insert;

import org.junit.Test;

/**
 * 适合基本有序的，数组量少，交换次数比冒泡少
 */

public class InsertSort {

    @Test
    public void TestInsertSort() {
        long start = System.currentTimeMillis();
        int[] arr = {16, 12, 34, 54, 2, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,};
        insertSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    @Test
    public void TestInsertSort2() {
        long start = System.currentTimeMillis();
        int[] arr = {16, 12, 34, 54, 2, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,};
        insertSort2(arr, 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    @Test
    public void TestBinaryInsertSort() {
        long start = System.currentTimeMillis();
        int[] arr = {16, 12, 34, 54, 2, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,};

        binaryInsertSort(arr);


        for (int i : arr) {
            System.out.print(i + " ");
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    @Test
    public void TestBinaryInsertSort2() {
        long start = System.currentTimeMillis();
        int[] arr = {16, 12, 34, 54, 2, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,};

        binaryInsertSort(arr, 1);


        for (int i : arr) {
            System.out.print(i + " ");
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    public static void insertSort(int[] arr) {
        /**
         * 插入排序 非递归
         * 适合链表，顺序表
         */
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                int tmp = arr[i];
                int j = i - 1;
                for (; j >= 0 && arr[j] > tmp; j--) {
                    arr[j + 1] = arr[j];
                }

                arr[j + 1] = tmp;
            }
        }
    }

    public static void insertSort2(int[] arr, int low) {
        // 递归方法

        if (low == arr.length) {
            return;
        }
        int t = arr[low];
        int j = low - 1;
        for (; j >= 0 && arr[j] > t; j--) {
            // 找一个位置 t < arr[j]

            arr[j + 1] = arr[j];
        }
        // 吧 t 放到 arr[j+1];

        arr[j + 1] = t;
        insertSort2(arr, low + 1);
    }

    public static void binaryInsertSort(int[] arr) {
        /**
         * 二分插入排序
         * 优化第二阶段查找效率，但无法优化移动效率
         * 只适合顺序表 
         */
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                int tmp = arr[i];

                int left = 0;
                int right = i - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (arr[mid] > tmp) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                int j = i - 1;
                for (; j >= left && arr[j] > tmp; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = tmp;
            }
        }
    }

    public static void binaryInsertSort(int[] arr, int low) {
        /**
         * 二分插入排序
         * 优化第二阶段查找效率，但无法优化移动效率
         * 只适合顺序表
         */
        if (low == arr.length) {
            return;
        }
        int n = arr.length;
        int tmp = arr[low];
        int left = 0;
        int right = low - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > tmp) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int j = low - 1;
        for (; j >= left && arr[j] > tmp; j--) {
            arr[j + 1] = arr[j];
        }
        arr[j + 1] = tmp;
        binaryInsertSort(arr, low + 1);

    }
}

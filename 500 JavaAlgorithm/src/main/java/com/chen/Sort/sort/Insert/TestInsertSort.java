package com.chen.Sort.sort.Insert;

import org.junit.Test;

/**
 * 适合基本有序的，数组量少，交换次数比冒泡少
 */

public class TestInsertSort {
    public static void main(String[] args) {
    }

    @Test
    public void TestInsertSort() {
        long start = System.currentTimeMillis();
        int[] arr = {16, 12, 34, 54, 2, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,};
        InsertSort.insertSort(arr);
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
        InsertSort.insertSort2(arr, 1);
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

        InsertSort.binaryInsertSort(arr);


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

        InsertSort.binaryInsertSort(arr, 1);


        for (int i : arr) {
            System.out.print(i + " ");
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

}

package com.chen.Sort.sort.Bucket;

import com.chen.Sort.sort.Insert.InsertSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName 排序
 * @package sort.Bucket
 * @className sort.Bucket.BucketSort
 * @date 2024/10/28 13:59
 * @description 桶排序
 */
public class BucketSort {

    public static void bucketSort(int[] arr) {
        // 1. 建立桶
//        int max = arr[0];
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            bucketList.add(new ArrayList<>());
        }

//         2. 将数据放入桶中
        for (int i : arr) {
            int idx = i / 10;
            bucketList.get(idx).add(i);
        }

        // 3. 对每个桶内的数据进行排序
        int j = 0;
        for (ArrayList bucket : bucketList) {
//            int[] bucketArr = Arrays.stream(bucket.toArray()).sorted().toArray();
//            System.out.println(Arrays.stream(bucketArr).toString());
            Integer[] arr2 = (Integer[]) bucket.toArray(new Integer[0]);
            // Jdk8  流处理批量拆包的装包

            int[] arr3 = Arrays.stream(arr2).mapToInt(Integer::valueOf).toArray();
            InsertSort.insertSort(arr3);
            System.out.println(Arrays.toString(arr3));
            for (int i : arr3) {
                arr[j++] = i;
            }


        }


    }

    public static void bucketSort2(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        // 1. 建立桶
//        int max = arr[0];
        int bucketSize = max - min + 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>(bucketSize);
        for (int i = 0; i < bucketSize; i++) {
            bucketList.add(new ArrayList<>());
        }

//         2. 将数据放入桶中
        for (int i : arr) {
            int idx = (i - min);
            bucketList.get(idx).add(i);
        }

        // 3. 对每个桶内的数据进行排序
        int j = 0;
        for (ArrayList bucket : bucketList) {
//            int[] bucketArr = Arrays.stream(bucket.toArray()).sorted().toArray();
//            System.out.println(Arrays.stream(bucketArr).toString());
            Integer[] arr2 = (Integer[]) bucket.toArray(new Integer[0]);
            // Jdk8  流处理批量拆包的装包

            int[] arr3 = Arrays.stream(arr2).mapToInt(Integer::valueOf).toArray();
            InsertSort.insertSort(arr3);
            System.out.println(Arrays.toString(arr3));
            for (int i : arr3) {
                arr[j++] = i;
            }


        }


    }

    public static void bucketSort3(int[] arr, int range) {
        /*
        优化 放几个桶
         */

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        // 1. 建立桶
//        int max = arr[0];
        int bucketSize = (max - min) / range + 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>(bucketSize);
        for (int i = 0; i < bucketSize; i++) {
            bucketList.add(new ArrayList<>());
        }

//         2. 将数据放入桶中
        for (int i : arr) {
            int idx = (i - min) / range;
            bucketList.get(idx).add(i);
        }

        // 3. 对每个桶内的数据进行排序
        int j = 0;
        for (ArrayList bucket : bucketList) {
//            int[] bucketArr = Arrays.stream(bucket.toArray()).sorted().toArray();
//            System.out.println(Arrays.stream(bucketArr).toString());
            Integer[] arr2 = (Integer[]) bucket.toArray(new Integer[0]);
            // Jdk8  流处理批量拆包的装包

            int[] arr3 = Arrays.stream(arr2).mapToInt(Integer::valueOf).toArray();
            InsertSort.insertSort(arr3);
            System.out.println(Arrays.toString(arr3));
            for (int i : arr3) {
                arr[j++] = i;
            }


        }


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

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 1, 2, 1, 4, 5, 7, 9, 11};
        bucketSort3(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}

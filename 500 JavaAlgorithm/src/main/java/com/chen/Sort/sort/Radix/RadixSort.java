package com.chen.Sort.sort.Radix;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName 排序
 * @package sort.Radix
 * @className sort.Radix.RadixSort
 * @date 2024/10/28 22:35
 * @description 基数排序
 *
 * LSD
 * MSD
 */
public class RadixSort {

    public static void main(String[] args) {
        String[] phones = {
                "13612345678", "18612345679", "18612345670", "18612345671", "18612345672", "18612345673", "18612345674",
                "15612345675", "18612345676", "18612345677",
                "18812345678", "18612345679", "18612345670", "18612345671", "18612345672", "18612345673", "18612345674",
                "13912345675", "12612345676", "18312345677",
                "12912345678",


        };
        String[] strings = {
                "158",
                "159",
                "118",
                "111",
                "139",
                "259",
                "190",
                "128",

        };

        radixSort(strings, 3);
        System.out.println("排序后：" + Arrays.toString(strings));

        radixSort(phones, 11);
        System.out.println("排序后：" + Arrays.toString(phones));
    }

    public static void radixSort(String[] arr, int length) {
        /**
         * 字符串排序
         * 1. 每个字符串长度相同
         * 2. 0 - 9 字符范围
         *
         */
        ArrayList<String>[] bucket = new ArrayList[10];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (int idx = length - 1; idx >= 0; idx--) {

            for (int i = 0; i < arr.length; i++) {
                bucket[arr[i].charAt(idx) - '0'].add(arr[i]);
            }

            int k = 0;
            for (int i = 0; i < bucket.length; i++) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    arr[k++] = bucket[i].get(j);
                }
                bucket[i].clear();
            }
        }
    }

    public static void radixSort3(String[] arr, int length) {
        /**
         * 字符串排序
         * 1. 每个字符串长度相同
         * 2. 0 - 9 字符范围
         * 高位优先，低位后，依次类推 这个顺序不对，
         * 需要先低位后，再高位，这样才符合从左到右的顺序
         *
         */
        ArrayList<String>[] bucket = new ArrayList[128];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (int idx = 0; idx < length; idx++) {

            for (String s : arr) {
                bucket[s.charAt(idx)].add(s);
            }

            int k = 0;
            for (ArrayList<String> strings : bucket) {
                for (String string : strings) {
                    arr[k++] = string;
                }
                strings.clear();
            }
        }
    }

    public static void radixSort2(String[] arr, int length) {
        /**
         * 字符串排序
         * 1. 每个字符串长度相同
         * 2. 0 - 9 字符范围
         *
         */
        ArrayList<String>[] bucket = new ArrayList[128];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (int idx = length - 1; idx >= 0; idx--) {

            for (int i = 0; i < arr.length; i++) {
                bucket[arr[i].charAt(idx)].add(arr[i]);
            }

            int k = 0;
            for (int i = 0; i < bucket.length; i++) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    arr[k++] = bucket[i].get(j);
                }
                bucket[i].clear();
            }
        }
    }
}

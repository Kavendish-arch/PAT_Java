package com.chen.Sort.sort.Bubble;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] arr2 = {5, 4, 3, 2, 1};
        bubbleSort2(arr2, arr.length - 1);
        for (int i : arr2) {
            System.out.print(i + " ");
        }

        System.out.println();
        int[] arr3 = {5, 4, 3, 2, 1};
        bubbleSort3(arr3);
        for (int i : arr3) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int left = arr.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    left = j - 1;
                }
            }
            if (left == 0) {
                break;
            }
//            System.out.println("第i轮 最后一次交换" + left);
        }
    }

    public static void bubbleSort2(int[] arr, int j) {
        /**
         * 递归方法实现 冒泡排序
         */
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                x = i;
            }
        }
        // 单递归
        bubbleSort2(arr, x);
    }

    public static void bubbleSort3(int[] arr) {
        while (true) {
            int x = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    x = i;
                }
            }
            if (x == 0) {
                break;
            }
        }
    }
}
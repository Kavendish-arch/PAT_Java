package com.chen.Sort.sort.heap;

/**
 *
 */
public class HeapSort {
    /**
     * 堆排序
     *
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {
        int n = nums.length;
        // 建堆语句
        for (int i = n / 2 - 1; i >= 0; i--) {
            HeapAdjust(nums, i, n - 1);
        }
        // 建堆语句
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            // swap(nums[0], nums[i]);
//            int tmp = nums[0];
//            nums[0] = nums[i];
//            nums[i] = tmp;
            HeapAdjust(nums, 0, i - 1);
        }
        return nums;
    }

    public static void HeapAdjust(int[] nums, int s, int m) {
        int top = nums[s];
        for (int j = 2 * s + 1; j <= m; ) {
            if (j < m && nums[j] < nums[j + 1]) {
                j++;
            }
            if (top >= nums[j]) {
                break;
            }
            nums[s] = nums[j];
            s = j;
            j = j * 2 + 1;
        }
        nums[s] = top;
    }

    public static void downAdjust2(int[] nums, int parentIndex, int length) {
        while (true) {
            // temp保存父节点值，用于最后的赋值
            int lelf = parentIndex * 2 + 1;
            int right = lelf + 1;
            int max = parentIndex;
            if (lelf < length && nums[lelf] > nums[max]) {
                max = lelf;
            }
            if (right < length && nums[right] > nums[max]) {
                max = right;
            }
            if (max == parentIndex) {
                break;
            }
            swap(nums, max, parentIndex);
            parentIndex = max;
        }
    }

    // 建堆
    public static void createHeap(int[] nums, int length) {
        // 非叶子节点
        // 建队O(N)
        for (int i = length / 2 - 1; i >= 0; i--) {
            downAdjust(nums, i, length);
        }
    }
    // 下潜 调整
    public static void downAdjust(int[] nums, int parentIndex, int length) {
        // temp保存父节点值，用于最后的赋值
        int lelf = parentIndex * 2 + 1;
        int right = lelf + 1;
        int max = parentIndex;
        if (lelf < length && nums[lelf] > nums[max]) {
            max = lelf;
        }
        if (right < length && nums[right] > nums[max]) {
            max = right;
        }
        if (max != parentIndex) {
            swap(nums, max, parentIndex);
            downAdjust(nums, max, length);
        }
    }

    // 交换
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] a = {5, 2, 3, 1};
        int[] arr = {16, 12, 34, 54, 2, 3};
        sortArray(arr);
        for (Object elem : arr) {
            System.out.print(elem + " ");
        }
    }
}

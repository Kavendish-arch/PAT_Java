package com.chen.Sort.Lianxi;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName 排序
 * @package Lianxi
 * @className Lianxi.XianDuiSort
 * @date 2024/10/29 13:07
 * @description 相对排序
 */


/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
 * <p>
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i]  各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class XianDuiSort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        countSort(arr1, arr2);
        return arr1;
    }

    public void countSort(int[] arr, int[] arr2) {
        int[] count = new int[1001];
        for (int i : arr) {
            count[i]++;
        }
        int index = 0;
        // arr2 中的每个元素 arr2[i] 都出现在 arr1 中
        for (int i : arr2) {
            while (count[i]-- > 0) {
                arr[index++] = i;
            }
        }
        // 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        XianDuiSort xianDuiSort = new XianDuiSort();
        xianDuiSort.relativeSortArray(arr1, arr2);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }


}

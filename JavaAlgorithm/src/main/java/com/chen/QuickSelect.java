
public class QuickSelect {

    public static int findNthLargest(int[] nums, int n) {
        if (nums == null || nums.length == 0 || n < 1 || n > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        return quickSelect(nums, 0, nums.length - 1, n);
    }

    private static int quickSelect(int[] nums, int left, int right, int n) {
        if (left == right) {
            return nums[left];
        }
        int pivotIndex = partition(nums, left, right);
        // 数组下标从0开始，第n大元素的实际位置是length - n
        if (nums.length - n == pivotIndex) {
            return nums[pivotIndex];
        } else if (nums.length - n < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, n);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, n);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] >= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int n = 2;
        System.out.println(findNthLargest(nums, n)); // 输出应为5
    }
}

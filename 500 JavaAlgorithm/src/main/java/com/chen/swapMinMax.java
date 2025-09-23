
public class swapMinMax {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 5};
        swapMaxMin(nums, 5);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void swapMaxMin(int[] nums, int n) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }

        int temp = nums[0];
        nums[0] = nums[maxIndex];
        nums[maxIndex] = temp;

        if (minIndex == 0) {
            minIndex = maxIndex;
        }

        temp = nums[nums.length - 1];
        nums[nums.length - 1] = nums[minIndex];
        nums[minIndex] = temp;
    }
}

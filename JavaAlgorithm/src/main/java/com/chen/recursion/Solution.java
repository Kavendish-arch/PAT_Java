package com.chen.recursion;

import java.util.Stack;

class Solution {

    public int search(int[] nums, int target) {
        int len = nums.length;

        int left = 0, right = len - 1;
        while (right >= left) {
            int mid = left + (left -right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (isBadVersion(mid)) {
                left = mid;
            } else {
                right = mid + 1;
            }
        }
        return -1;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }

    class CQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int sta_flag = 0;
        public CQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
            this.sta_flag = 1;
        }

        public void appendTail(int value) {
            stack2.push(value);
        }

        public int deleteHead() {

            while(stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

    }


}
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
package com.chen.dp;

import java.util.Arrays;


class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();

        int target = sum / 2;
//        System.out.println(sum, target);
        return 0;
    }

//    public static void main(String[] args) {
//        int[] stones = { 2, 7, 4, 1, 8, 1 };
//        Solution s = new Solution();
//        s.lastStoneWeightII(stones);
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(1, 2);
//        map.get(1);
//        for(int i : map.keySet())
//    }
}

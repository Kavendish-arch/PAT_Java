package stream;

import java.util.Arrays;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        int k = right;
        while (left < right)
        {
            int speed = left + (right - left) / 2;
            int time = getTime(piles, speed);
            if (time <=h)
            {
                k = speed;
                right = speed;

            }
            else{
                left = speed + 1;
            }

        }
        return k;
    }
    public static int getTime(int[] piles, int speed)
    {
        int time = 0;
        for (int pile : piles)
        {
            time += pile / speed;
            if (pile % speed != 0)
            {
                time++;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 5;

        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(piles, h));
    }
}
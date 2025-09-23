//package com.chen.moni;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
* @projectName PAT
* @package com.chen.moni
* @className com.chen.moni.Main

* @author chenyingtao
* @date 2025/3/30 17:20
* @version 1.0
* @description @todo 
*/
public class Main {
    // 小友是公司的会议空管理员，公司一共有m个会议室，使用一个整数数组表示,其中下标j别八处数家有不理公0，中)会这到的家数姐表示，县中下标为i的值为[startTime.用友endTime, num]代表第i个(0<=|<n)日程安排将会在半封闭区间内[startTime;，endTime;
    //^∞a9HH43
    //举办，num; 为该日程参与人数。
    // 贪心算法
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n;
        m = in.nextInt();
        n = in.nextInt();
        in.nextLine();

        int [] capacity = new int[m];
        int [][] meeting_list = new int[n][3];
        for(int i = 0; i < m; i++){
            capacity[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            meeting_list[i][0] = in.nextInt();
            meeting_list[i][1] = in.nextInt();
            meeting_list[i][2] = in.nextInt();
        }

        System.out.println(canAttendMeetings(meeting_list, m));
    }

    public static boolean canAttendMeetings(int[][] intervals, int m) {
        if (intervals == null || intervals.length == 0) return true;

        // 按会议开始时间排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 使用优先队列（最小堆）来跟踪会议室的结束时间
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(m);

        for (int[] interval : intervals) {
            // 如果有会议室在当前会议开始前已经空闲，就重新使用这个会议室
            if (!minHeap.isEmpty() && minHeap.peek() <= interval[0]) {
                minHeap.poll();
            }

            // 将当前会议的结束时间加入到优先队列中
            minHeap.offer(interval[1]);

            // 如果使用的会议室数量超过了m，返回false
            if (minHeap.size() > m) {
                return false;
            }
        }

        return true;
    }
}

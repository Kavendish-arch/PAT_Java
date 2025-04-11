//package com.chen.moni;

/**
* @projectName PAT
* @package com.chen.moni
* @className com.chen.moni.MeetingRoomScheduler

* @author chenyingtao
* @date 2025/3/30 17:27
* @version 1.0
* @description @todo 
*/
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomScheduler {
    public boolean canAttendMeetings(int[][] intervals, int m) {
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

    public static void main(String[] args) {
        MeetingRoomScheduler scheduler = new MeetingRoomScheduler();
        int[][] intervals = {{1, 3, 2}, {2,4,3}, {3,5,1},{5,7,2}};
        int m = 2;
        boolean canAttend = scheduler.canAttendMeetings(intervals, m);
        System.out.println(canAttend);  // 应该输出true或false
    }
}

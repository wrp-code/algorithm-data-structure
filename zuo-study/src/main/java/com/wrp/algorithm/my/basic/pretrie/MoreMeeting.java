package com.wrp.algorithm.my.basic.pretrie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 如何安排会议，让会议次数最多
 * @author wrp
 * @since 2025-03-11 08:04
 **/
public class MoreMeeting {

    public record Meeting(int start, int end) {}

    public int arrange(Meeting[] meetings, int start) {
        Arrays.sort(meetings, Comparator.comparingInt(Meeting::end));
        int res = 0;
        for (int i = 0; i < meetings.length; i++) {
            if(meetings[i].start >= start) {
                res++;
                start = meetings[i].end;
            }
        }
        return res;
    }

    public int arrangeMy(Meeting[] meetings, int start) {
        Queue<Meeting> queue = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
        for (Meeting meeting : meetings) {
            queue.offer(meeting);
        }

        int res = 0;
        while (!queue.isEmpty()) {
            Meeting meeting = queue.poll();
            if(meeting.start >= start) {
                res++;
                start = meeting.end;
            }
        }
        return res;
    }
}

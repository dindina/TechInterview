package heap;

import javafx.scene.effect.DisplacementMapBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/meeting-rooms-ii/
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
 */
public class MeetingRoomsII {


    public int minMeetingRooms(int[][] intervals) {

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int [] array : intervals)
        {
            System.out.println("start");
            Integer start = array[0];
            Integer end = array[1];
            if(minheap.size() == 0)// for the first condition only
            {
                minheap.offer(end);
                continue;
            }

            if(start <  minheap.peek()) // need a new room
            {
                minheap.offer(end);
            }
            else
            {
                minheap.poll();
                minheap.offer(end);
            }


        }
        System.out.println("size " + minheap.size());
        if(minheap.size() >0)
            return minheap.size();
        else
            return -1;

    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                //{0,30},{5,10},{15,20}
                {2,7}
        };
        System.out.println("final "+new MeetingRoomsII().minMeetingRooms(intervals));
    }


}

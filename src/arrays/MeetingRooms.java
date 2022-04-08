package arrays;

import java.util.Arrays;

/*
Given an array of meeting time intervals
where intervals[i] = [starti, endi], determine if a person could attend all meetings.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true


 */
public class MeetingRooms {

    public static void main(String[] args) {
        //int[][] intervals = {{0,30},{5,10},{15,20}};
        int[][] intervals = {{7,10},{2,4}};
        System.out.println(new MeetingRooms().canAttendMeetings(intervals));

    }
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a1,a2)->a1[0]-a2[0]);
        for(int[] array : intervals)
        {
            System.out.println(array[0] + "," + array[1]);
        }
        // make sure each meeting ends before the next one starts
        for(int i=1;i<intervals.length;i++)
        {
            int currentStartTime = intervals[i][0];
            int prevEndTime = intervals[i-1][1];
            if(currentStartTime < prevEndTime)
                return false;
        }
        return true;
    }
}

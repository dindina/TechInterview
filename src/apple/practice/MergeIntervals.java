package apple.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(arr1, arr2)-> arr1[0]-arr2[0]);
        // after sorting , init the output
        List<int[]> output_list = new ArrayList<>();
        int[] current_interval = intervals[0]; // set to the first interval after sorting
        output_list.add(current_interval);

        for(int[] inter : intervals)
        {
            int current_begin = current_interval[0];
            int current_end = current_interval[1];

            int next_begin = inter[0];
            int next_end = inter[1];

            if(current_end >= next_begin)
            {
                current_interval[1] = Math.max(current_end,next_end);
            }
            else
            {
                current_interval = inter;
                output_list.add(current_interval);
            }
        }
        return output_list.toArray(new int[output_list.size()][]);

    }

    public static void main(String[] args) {

        int[][] intervals = new int[][]
                {{15,18},{2,6},{8,10},{1,3}};
        new MergeIntervals().merge(intervals);

    }

}

package apple.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArrays {
    public static void main(String[] args) {
        int[][] intervals = new int[][]
                {{15,18},{2,6},{8,10},{1,3}};

        List<int[]> outputlist = new ArrayList<>();
        int[][] newin = outputlist.toArray(new int[outputlist.size()][]);

        // arrays  to list
        List<int[]> list = Arrays.asList(intervals);
        for(int[] oned : intervals)
        {
            System.out.print(oned[0]  + "," + oned[1]);
        }

        // to convert list to array

        List<Integer> list1= new ArrayList<>();
        list1.add(10);list1.add(20);
        //int[] intarray = list1.stream().mapToInt(i->i).toArray();

    }
}

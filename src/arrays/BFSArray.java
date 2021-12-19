package arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;


public class BFSArray {

    public static void main(String[] args) {
        int [][] twod = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}
        };

        TraverseDFS(twod);
    }

    private static void TraverseDFS(final int[][] twod) {
        int [][] directions = new int[][]{
                {-1,0},//up
                {0,1},//right
                {1,0},//down
                {0,-1},//left
        };
        boolean [][] visited = new boolean[twod.length+1][twod[0].length+1];
        Queue<List<Integer>> nodestoVisit = new ArrayDeque<>();
        nodestoVisit.offer(Arrays.asList(0,0));
        while(nodestoVisit.size()>0)
        {
            List<Integer> currentPair  = nodestoVisit.poll();
            int currentRow = currentPair.get(0);
            int currentCol = currentPair.get(1);

            if(currentRow <0 || currentCol <0 || currentRow >= twod.length || currentCol >= twod[0].length || visited[currentRow][currentCol])
            {
                continue;
            }

            visited[currentRow][currentCol]=true;
            int currentItem = twod[currentRow][currentCol];
            System.out.print(currentItem  + "->");
            for(int i=0 ; i< directions.length;i++) {
                int[] direction = directions[i];
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];
                nodestoVisit.add(Arrays.asList(newRow, newCol));
            }
        }






    }


}

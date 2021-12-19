package arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;


public class IslandProblem {
    public static void main(String[] args) {
        int twod [][] = new int[][]{
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,1},
                {0,0,0,1,1}
        };

        int directions [][] = new int[][]{
                {-1,0},
                {0,1},
                {1,0},
                {0,-1}
        };
        int islandCount = 0;
        for(int row=0; row< twod.length;row++) {
            for (int col = 0; col < twod[row].length; col++) {
                if(twod[row][col] == 1) {
                    islandCount++; // increment the countter
                    twod[row][col] =0; // change the selected island to zero
                    // start the bfs traversal
                    Queue<List<Integer>> nodesToVisit = new ArrayDeque<>();
                    // add the position of the current element to the queue
                    nodesToVisit.offer(Arrays.asList(row,col));
                    while(nodesToVisit.size() >0)
                    {
                        List<Integer> visitedNode  = nodesToVisit.poll();
                        int currentrow = visitedNode.get(0);
                        int currentcolumn = visitedNode.get(1);
                        System.out.println("currentrow "+currentrow +", currentcolumn"+currentcolumn );
                        // move around in the directions
                        for(int i=0; i< directions.length;i++) {
                            int[] currentDirection = directions[i];
                            int nextRow = currentrow+ currentDirection[0];
                            int nextColumn = currentcolumn+ currentDirection[1];
                            System.out.println("nextRow "+nextRow +", nextColumn"+nextColumn );
                            // check if we are out of bounds
                            if(nextRow <0 || nextRow >= twod.length ||
                            nextColumn <0 || nextColumn >= twod[0].length){
                                continue;
                            }
                            // add to the BFS if it is 1 and change it to 0
                            if(twod[nextRow][nextColumn] == 1)
                            {
                                nodesToVisit.offer(Arrays.asList(nextRow,nextColumn));
                                twod[nextRow][nextColumn]=0;
                            }
                        }

                    }

                }
            }

        }
        System.out.println("no if islands is " +islandCount);

    }
}

package graphs;





//import org.apache.commons.lang3.tuple.ImmutablePair;
//import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.Queue;

/*

https://leetcode.com/problems/island-perimeter/

You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

 */
/*public class IslandPerimeter {

    public int islandPerimeterbfs(int[][] grid) {
        int perimeter = 0;
        int directions[][]={
                {-1,0},{0,-1},{1,0},{0,1}
        };

        Queue<ImmutablePair<Integer,Integer>> queue = new LinkedList<>();

        for(int i=0; i < grid.length ; i++)
            for(int j=0; j < grid[0].length ; j++)
                if(grid[i][j] ==1)
                    queue.offer(new ImmutablePair(i,j));

        boolean visited[][] = new boolean[grid.length][grid[0].length];

        while(!queue.isEmpty())
        {
            Pair<Integer,Integer> item = queue.poll();
            int row = item.getKey();
            int col = item.getValue();

            //go to all directions from this item
            for(int[] direction : directions ) {
                int r = row + direction[0];
                int c = col + direction[1];
                if(isValid(r,c,grid))
                {
                    if(grid[r][c] ==1) // this is an island
                    {
                        if(!visited[r][c]) {
                            visited[r][c] = true;
                            queue.offer(new ImmutablePair<>(r,c));
                        }
                    }

                }
            }


        }
        return perimeter;

    }

    private boolean isValid(int r, int c, int [][] grid) {
        if(r>=0 && r<grid[0].length && c >=0 && c < grid[0].length)
            return true;
        return false;
    }

    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid[0].length ==0 || grid.length ==0) return 0;
        int perimeter=0;
        for(int i =0 ; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 && grid[i - 1][j] == 1)
                        perimeter -= 2;
                    if (j > 0 && grid[i][j - 1] == 1)
                        perimeter -= 2;
                }

            }
        }
        return perimeter;
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0,}
        };
        System.out.println("hee");
        System.out.println(new IslandPerimeter().islandPerimeter(grid));

    }
}*/

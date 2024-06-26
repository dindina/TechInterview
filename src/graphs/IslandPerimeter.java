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
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int result=0;

        for(int i=0 ; i < grid.length ; i++)
        for(int j=0; j< grid[0].length ; j++)
        {
            if(grid[i][j] ==1) {
                result += 4;

                // check up
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    result -= 2;
                }
                //check left
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    result -= 2;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] map = new int[][]{
                {0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,1}
        };

        System.out.println(new IslandPerimeter().islandPerimeter(map));

    }



}

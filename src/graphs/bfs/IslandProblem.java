package graphs.bfs;

//import org.apache.commons.lang3.tuple.ImmutablePair;
//import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/*
https://leetcode.com/problems/number-of-islands/
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1


Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */
public class IslandProblem {

    public int numIslands(char[][] grid) {

        int island = 0;

        int directions[][] = new int[][]{
                {1,0},{0,1},{-1,0},{0,-1}
        };
        boolean [][] visited = new boolean[grid.length][];
        for(int i=0; i <grid.length;i++)
        {
            for(int j=0; j <grid[i].length;j++)
            {
                if(grid[i][j] =='1')
                {
                    island++;
                    grid[i][j]='0';
                    Queue<List<Integer>> queue = new LinkedList<>();
                    queue.offer(Arrays.asList(i,j));
                    while(!queue.isEmpty())
                    {
                        List<Integer> item = queue.poll();
                        int row = item.get(0);
                        int col = item.get(1);
                        for( int [] direction : directions)
                        {
                            int newrow = row + direction[0];
                            int newcol = col + direction[1];

                                if(newrow<0 || newrow >=grid.length || newcol <0 ||newcol >= grid[0].length)
                                {
                                    continue;
                                }

                            if(grid[newrow][newcol] =='1' )
                            {
                                queue.offer(Arrays.asList(newrow,newcol));
                                grid[newrow][newcol] ='0';
                            }

                        }
                    }


                }
            }
        }
        System.out.println("island " + island);
        return island;


    }

    public static void main(String[] args) {
        char [][]grid  = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(new IslandProblem().numIslands(grid));


    }



}
